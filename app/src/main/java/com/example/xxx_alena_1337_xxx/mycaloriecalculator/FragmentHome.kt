package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
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
import kotlinx.android.synthetic.main.fragment_fragment_home.*
import kotlinx.android.synthetic.main.fragment_fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*
import javax.xml.datatype.DatatypeConstants.YEARS




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 *
 */

class FragmentHome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        caloriesNormal()
        sumProducts()

        editText_search_home.setOnClickListener {
            recycler_search.visibility = View.VISIBLE
        }

        searchProducts()
    }

    private fun searchProducts(){
        editText_search_home.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val searchText = searchText.text.toString().trim()

                val ref = FirebaseDatabase.getInstance().getReference("/products")
                val query = ref
                    .orderByChild("product_name")
                    .startAt(searchText)
                    .endAt(searchText + '\uf8ff')
                    .limitToFirst(9)

                query.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(result: DataSnapshot) {

                        val products = mutableListOf<Product>()
                        val adapter = GroupAdapter<ViewHolder>()

                        result.children.forEach {
                            val product = it.getValue(Product::class.java)
                            if (product != null) {
                                products.add(product)
                                adapter.add(ProductItem(product))
                            }
                        }

                        adapter.setOnItemClickListener { item, view ->

                            val user = FirebaseAuth.getInstance().currentUser
                            val uid = user!!.uid

                            val userProducts = FirebaseDatabase.getInstance()
                                .getReference("/users/$uid")
                                .child("/products_item")

                            val productItem = item as ProductItem
                            val idProduct = FirebaseAuth.getInstance().uid ?: ""
                            val name = productItem.product.product_name
                            val grams = 100.toString()
                            val calories = productItem.product.calories

                            val productsList = ProductsList(idProduct,name, grams, calories)
                            userProducts.push().setValue(productsList)
                        }

                        recyclerView_search_hom.adapter = adapter
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })

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

                var totalCalories = 0f
                var totalGrams = 0f

                p0.children.forEach {
                    val product = it.getValue(ProductsList::class.java)
                    if (product != null) {
                        adapter.add(ProductListItem(product))
                        totalCalories += product.calories!!.toFloat()
                        totalGrams += product.grams!!.toFloat()

                        val calories =(totalCalories*totalGrams)/100

                        var norma = textView_normal.text.toString().toFloat()

                        norma -= calories

                        textView_normal.text = norma.toString()
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



    private fun caloriesNormal() {

        //var user = User()
        val index: Float
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        var user = User(
            uid= uid!!, bornAt = ref.child("/old").toString(),
            userName = ref.child("/heightUser").toString(),
            heightUser = ref.child("/heightUser").toString(),
            weightUser = ref.child("/heightUser").toString(),
            sex = ref.child("/heightUser").toString()
        )



        val format = SimpleDateFormat()
        format.applyPattern("dd.MM.yyyy")
        val start = format.parse(user.bornAt)


        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val s = sdf.format(Date())
        val end=format.parse(s)



        //val years = ChronoUnit.YEARS.between(start, end)
        val years = 30

        val height = user.heightUser.toFloat()
        val weight = user.weightUser.toFloat()

        if(user.sex=="male"){


            index = (88.36 + (13.4+height)+(4.8+weight)-(5.7*years)).toFloat()

            textView_normal.text=index.toString()
        }
        else{

            index = (447.6 + (9.2+height)+(3.1+weight)-(4.3*years)).toFloat()
            textView_normal.text=index.toString()
        }

    }

}
