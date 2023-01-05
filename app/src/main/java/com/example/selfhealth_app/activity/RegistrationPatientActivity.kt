package com.example.selfhealth_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.selfhealth_app.R
import kotlinx.android.synthetic.main.activity_room.*

class RegistrationPatientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_patient)

        buttonBack.setOnClickListener(){
            finish()
        }
    }
}