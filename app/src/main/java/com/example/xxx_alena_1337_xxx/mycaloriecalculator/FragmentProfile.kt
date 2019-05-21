package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Bundle
import android.os.Message
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
import kotlinx.android.synthetic.main.fragment_fragment_profile.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.view.*
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
class FragmentProfile : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_profile, container, false)

        //fetchUser()
    }

//    private fun fetchUser(){
//        val ref = FirebaseDatabase.getInstance().getReference("/users")
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                val adapter= GroupAdapter<ViewHolder>()
//
//                p0.children.forEach {
//                    val user = it.getValue(User::class.java)
//                    if (user!=null){
//                        adapter.add(UserItem(user))
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
//
//    }

}

//class UserItem(val user: User): Item<ViewHolder>(){
//
//    override fun bind(viewHolder: ViewHolder, position: Int) {
//
//        viewHolder.itemView.text_userName.text=user.userName
//        viewHolder.itemView.text_userHeight.text=user.heightUser
//        viewHolder.itemView.text_userWeight.text=user.weightUser
//
//    }
//    override fun getLayout(): Int {
//
//        return R.layout.layout_list
//
//    }
//}

