package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_breakfast.*

class BreakfastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)

        image_arrow_breakfast.setOnClickListener() {

            val intent = Intent(this, FragmentHome::class.java)
            startActivity(intent)
        }
    }
}
