package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xxx_alena_1337_xxx.mycaloriecalculator.UserInfo.uid
import com.google.firebase.auth.FirebaseAuth
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


class FragmentProfile : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_profile, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchUser()
    }

    private fun fetchUser() {

        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        text_userName.text = ref.child("/userName").toString()
        text_userHeight.text = ref.child("/heightUser").toString()
        text_userWeight.text = ref.child("/weightUser").toString()
    }

}


