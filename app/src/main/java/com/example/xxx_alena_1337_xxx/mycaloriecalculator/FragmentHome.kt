package com.example.xxx_alena_1337_xxx.mycaloriecalculator


import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
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
        //caloriesNormal()
    }



//    private fun caloriesNormal() {
//
//        var user = User()
//        val index: Float
//        val uid = FirebaseAuth.getInstance().uid
//        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
//
//        ref.child("/old").onChange { data ->
//            user.bornAt = data.value?.toString()!!
//        }
//
//        ref.child("/heightUser").onChange { data ->
//            user.heightUser = data.value?.toString()!!
//        }
//
//        ref.child("/weightUser").onChange { data ->
//            user.weightUser = data.value?.toString()!!
//        }
//
//
//
//        val format = SimpleDateFormat()
//        format.applyPattern("dd.MM.yyyy")
//        val start = format.parse(user.bornAt)
//
//
//        val sdf = SimpleDateFormat("dd.MM.yyyy")
//        val s = sdf.format(Date())
//        val end=format.parse(s)
//
//        val years = ChronoUnit.YEARS.between(start, end)
//
//        if(user.sex=="male"){
//
//
//            index = (88.36 + (13.4+user.hieghtUser)+(4.8+user.wieghtUser)-(5.7*years)).toFloat()
//
//            textView_aloriesNorm.text=index.toString()
//        }
//        else{
//
//            index = (447.6 + (9.2+user.hieghtUser)+(3.1+user.wieghtUser)-(4.3*years)).toFloat()
//            textView_aloriesNorm.text=index.toString()
//        }
//
//    }

}
