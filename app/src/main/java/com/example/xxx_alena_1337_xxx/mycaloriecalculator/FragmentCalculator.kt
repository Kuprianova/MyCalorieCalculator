package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_fragment_calculator.*
import kotlinx.android.synthetic.main.layout_list.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

@Suppress("UNREACHABLE_CODE")
class FragmentCalculator : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_calculator, container, false)

        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(ProductItem())
        adapter.add(ProductItem())
        adapter.add(ProductItem())

        recycler_search.adapter = adapter



        //fetchProducts()

    }

//    private fun fetchProducts(){
//        val ref = FirebaseDatabase.getInstance().getReference("/products")
//        ref.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                val adapter=GroupAdapter<ViewHolder>()
//
//                p0.children.forEach {
//                    val product = it.getValue(Product::class.java)
//                    if (product!=null){
//                        adapter.add(ProductItem(product))
//                    }
//                }
//
//                recycler_search.adapter =adapter
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//
//        })

    //}

}

class ProductItem(): Item<ViewHolder>(){

    override fun bind(viewHolder: ViewHolder, position: Int) {

        //viewHolder.itemView.textView_product_name.text=product!!.product_name
        //viewHolder.itemView.text_calories_search.text=product.calories

    }
    override fun getLayout(): Int {

        return R.layout.layout_list

    }
}