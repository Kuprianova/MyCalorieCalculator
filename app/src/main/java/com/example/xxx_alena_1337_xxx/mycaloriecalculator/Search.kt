package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

object Search {

    fun fetchProducts(searchText: EditText, recycler_search: RecyclerView) {

        searchText.addTextChangedListener(object : TextWatcher {
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
                                .child("/products_list")

                            val productItem = item as ProductItem
                            val idProduct = FirebaseAuth.getInstance().uid ?: ""
                            val name = productItem.product.product_name
                            val grams = 100.toString()
                            val calories = productItem.product.calories

                            val productsList = ProductsList(idProduct,name, grams, calories)
                            userProducts.push().setValue(productsList)
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