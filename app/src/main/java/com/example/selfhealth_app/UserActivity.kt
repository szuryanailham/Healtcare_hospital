package com.example.selfhealth_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.selfhealth_app.helper.Constant
import com.example.selfhealth_app.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedpref = PreferencesHelper(this)
        textEmail.text = sharedpref.getString(Constant.PREF_EMAIL)
        buttonLogout.setOnClickListener{
            sharedpref.clear()
            showMessage("Logout Success")
            moveIntent()
        }

    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun moveIntent() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}