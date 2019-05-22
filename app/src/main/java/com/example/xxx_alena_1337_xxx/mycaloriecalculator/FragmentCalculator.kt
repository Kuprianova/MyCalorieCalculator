package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_fragment_calculator.*
import kotlinx.android.synthetic.main.layout_list.view.*
import kotlinx.android.synthetic.main.products_list.view.*

class FragmentCalculator : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sumProducts()

        searchText.setOnClickListener {
            recycler_search.visibility = View.VISIBLE
        }

        Search.fetchProducts(searchText, recycler_search)
    }

    private fun sumProducts() {

        val user = FirebaseAuth.getInstance().currentUser
        val uid = user!!.uid

        val userProducts = FirebaseDatabase.getInstance()
            .getReference("/users/$uid")
            .child("/products_list")

        userProducts.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                p0.children.forEach {
                    val product = it.getValue(ProductsList::class.java)
                    if (product != null) {
                        adapter.add(ProductListItem(product))
                    }
                }

                recycler_list_product.adapter = adapter
                recycler_search.visibility = View.GONE
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}



class ProductItem(val product: Product): Item<ViewHolder>(){

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView_product_name.text= product.product_name
        viewHolder.itemView.text_calories_search.text= product.calories
    }

    override fun getLayout(): Int {
        return R.layout.layout_list
    }
}

class ProductListItem(val product: ProductsList): Item<ViewHolder>(){

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView_nameProduct.text = product.product_name
        viewHolder.itemView.textView_calories.text= product.calories
    }

    override fun getLayout(): Int {
        return R.layout.products_list
    }
}