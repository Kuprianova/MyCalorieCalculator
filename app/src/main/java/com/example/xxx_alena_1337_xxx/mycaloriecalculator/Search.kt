package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_fragment_calculator.*
import kotlinx.android.synthetic.main.layout_list.*

object Search {

      fun fetchProducts(searchText: EditText, textView_product_name: TextView, text_calories_search: TextView, recycler_search: RecyclerView) {

        searchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val searchText = searchText.getText().toString().trim()

                val ref = FirebaseDatabase.getInstance().getReference("/products")


                val query = ref.orderByChild("product_name").startAt(searchText).endAt(searchText + "\uf8ff").limitToFirst(9)//endAt(searchText + "\uf8ff")


                query.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(p0: DataSnapshot) {
                        val adapter = GroupAdapter<ViewHolder>()

                        p0.children.forEach {
                            val product = it.getValue(Product::class.java)
                            if (product != null) {
                                adapter.add(ProductItem(product))
                            }
                        }

                        adapter.setOnItemClickListener { item, view ->


                            //                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser()
//                            String userid=user.getUid()

                            //val ref=FirebaseDatabase.getReference('/users').orderByKey().equalTo(yourUID)
                            val auth = FirebaseAuth.getInstance()
                            val authListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
                                val firebaseUser = firebaseAuth.currentUser
                                if (firebaseUser != null) {
                                    val userId = firebaseUser.uid
                                    //.child("/$userId")

                                }
                            }


                            val ref_product = FirebaseDatabase.getInstance().getReference("/users").child("/$authListener").child("/products_list")


                            val name = textView_product_name.text.toString()
                            val grams = 100.toString()
                            val calories = text_calories_search.text.toString()


                            val product = ProductsList(name, grams, calories)
                            ref_product.push().setValue(product)


                        }

                        recycler_search.adapter = adapter
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })


    }
}