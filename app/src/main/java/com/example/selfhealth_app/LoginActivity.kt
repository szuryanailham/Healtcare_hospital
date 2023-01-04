package com.example.selfhealth_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.selfhealth_app.helper.Constant
import com.example.selfhealth_app.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var  sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedpref = PreferencesHelper(this)

        buttonLogin.setOnClickListener {
            if (editEmail.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                saveSession(editEmail.text.toString(), editPassword.text.toString())
                showMessage("Login Success")
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun saveSession(email: String, password: String) {
        sharedpref.put(Constant.PREF_EMAIL, email)
        sharedpref.put(Constant.PREF_PASSWORD, password)
        sharedpref.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}