package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_fragment_home.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 *
 */
@Suppress("UNREACHABLE_CODE")
class FragmentHome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_home, container, false)



        //caloriesNormal()


    }

//    private fun caloriesNormal() {
//        val ref = FirebaseDatabase.getInstance().getReference("/user")
//        ref.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                val adapter = GroupAdapter<ViewHolder>()
//
//                p0.children.forEach {
//                    val user = it.getValue(User::class.java)
//                    if (user != null) {
//                        adapter.add(NormalCaloriesItem(user))
//                    }
//                }
//
//                recycler_search.adapter = adapter
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//
//        })
//    }


}

//class NormalCaloriesItem(val user: User): Item<ViewHolder>(){
//
//    override fun bind(viewHolder: ViewHolder, position: Int) {
//
//        val index: Float
//        val hieght: Float = user.heightUser!!.toFloat()
//        val wieght: Float = user.weightUser!!.toFloat()
//        val old: Float= 30.toFloat()
//
//        if(user.sex=="male"){
//
//
//            index = (88.36 + (13.4+hieght)+(4.8+wieght)-(5.7*old)).toFloat()
//
//            viewHolder.itemView.textView_aloriesNorm.text=index.toString()
//        }
//        else{
//
//            index = (447.6 + (9.2+hieght)+(3.1+wieght)-(4.3*old)).toFloat()
//            viewHolder.itemView.textView_aloriesNorm.text=index.toString()
//        }
//
//    }
//    override fun getLayout(): Int {
//
//        return R.layout.fragment_fragment_home
//
//    }
//}
