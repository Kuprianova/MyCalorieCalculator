package com.example.xxx_alena_1337_xxx.mycaloriecalculator

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
class RegistrationActivity : Activity() {

    private lateinit var auth: FirebaseAuth


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        auth = FirebaseAuth.getInstance()


        setContentView(R.layout.activity_registration)

        val lifestyle = arrayOf("Минимальный (без физической нагрузки)", "Низкий (посещение спортзала 1-2 раза в неделю)",
                "Средний (посещение спортзала 3-4 раза в неделю)", "Высокий (высокая физическая нагрузка на работе)")

        val adapter = ArrayAdapter(
                this, // Context
                android.R.layout.simple_spinner_item, // Layout
                lifestyle // Array
        )

        // Set the drop down view resource
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with dapter
        spinner_lifestyle.adapter = adapter;

        // Set an on item selected listener for spinner object
        spinner_lifestyle.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Display the selected item text on text view
                //text_view.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }


        next_button_registrtion.setOnClickListener() {

                performRegister()



        }


        textAuthorization.setOnClickListener() {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }

    }


    private fun performRegister() {
        val email = email_editText_registration.text.toString()
        val password = password_editText_registration.text.toString()
        val name = userName_editText.text.toString()
        var sex:String=""
        val old = editText_birthday_reg.text.toString()
        val weight = editText_weight_reg.text.toString()
        val height = editText_height_reg.text.toString()


//        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupSex)
//        radioGroup?.setOnCheckedChangeListener{group,isChecked->
//            var text = "You selected: "
//            val sex = if (R.id.radioButton_male == isChecked) "male" else "female"
//            text += if (R.id.radioButton_male == isChecked) "male" else "female"
//            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
//        }

        if (email.isEmpty() || password.isEmpty()|| name.isEmpty()|| old.isEmpty()|| weight.isEmpty()|| height.isEmpty()) {
            Toast.makeText(this, "Пожалуйста заполните все поля", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("RegistrationActivity", "Email is: " + email)
        Log.d("RegistrationActivity", "Password: $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    // else if successful
                    Log.d("RegistrationActivity", "Successfully created user with uid: ${it.result!!.user.uid}")

                    saveUserToFirebaseDatabase(sex)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener{
                    Log.d("RegistrationActivity", "Failed to create user: ${it.message}")
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
                }
    }

    private fun saveUserToFirebaseDatabase(sex:String) {



        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")


        val user = User(uid,userName_editText.text.toString(), sex,editText_birthday_reg.text.toString(),
                "",editText_height_reg.text.toString(),editText_weight_reg.text.toString())



        ref.setValue(user)
                .addOnSuccessListener {
                    Log.d("RegistrationActivity", "Finally we saved the user to Firebase Database")
                }
                .addOnFailureListener {
                    //Log.d("RegistrationActivity", "Failed to set value to database: ${it.message}")
                }
    }


}

