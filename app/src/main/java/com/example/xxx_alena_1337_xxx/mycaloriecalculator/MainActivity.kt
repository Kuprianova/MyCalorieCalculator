package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragment_home.*

class MainActivity : AppCompatActivity() {

    val manager= supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_calculator -> {
                //message.setText(R.string.title_home)
                createFragmentCalculator()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                //message.setText(R.string.title_dashboard)
                createFragmentHome()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                //message.setText(R.string.title_notifications)
                createFragmentProfile()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragmentCalculator()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }



    fun createFragmentCalculator(){
        val transaction = manager.beginTransaction()
        val fragment=FragmentCalculator()
        transaction.replace(R.id.fragmentholder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentHome(){
        val transaction = manager.beginTransaction()
        val fragment=FragmentHome()
        transaction.replace(R.id.fragmentholder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun createFragmentProfile(){
        val transaction = manager.beginTransaction()
        val fragment=FragmentProfile()
        transaction.replace(R.id.fragmentholder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
