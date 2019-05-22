package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_fragment_profile.*

class FragmentProfile : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchUser()
    }

    private fun fetchUser() {

        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        ref.child("/userName").onChange { data ->
            text_userName.text = data.value?.toString()
        }

        ref.child("/heightUser").onChange { data ->
            text_userHeight.text = data.value?.toString()
        }

        ref.child("/weightUser").onChange { data ->
            text_userWeight.text = data.value?.toString()
        }
    }

}

fun DatabaseReference.onChange(action: (DataSnapshot) -> Unit) {
    val listener = object : ValueEventListener {

        override fun onDataChange(p0: DataSnapshot) {
            action(p0)
        }

        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented")
        }
    }
    addValueEventListener(listener)
}

