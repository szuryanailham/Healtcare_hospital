package com.example.selfhealth_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.adapter.HospitalAdapter
import com.example.selfhealth_app.helper.Constant
import com.example.selfhealth_app.helper.PreferencesHelper
import com.example.selfhealth_app.model.HospitalModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var sharedpref : PreferencesHelper
    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var hospitalAdapter: HospitalAdapter
    private lateinit var listRumahsakit: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpref = PreferencesHelper(this)
        textEmail.text = sharedpref.getString(Constant.PREF_EMAIL)
        buttonLogout.setOnClickListener{
            sharedpref.clear()
            showMessage("Logout Success")
            moveIntent()
        }

        setupList()

        buttonKamar.setOnClickListener(){
            Intent(this, RoomActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        getRumahSakit()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun moveIntent() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun setupList() {
        listRumahsakit = findViewById(R.id.list_hospital)
        hospitalAdapter = HospitalAdapter(arrayListOf())
        listRumahsakit.adapter = hospitalAdapter
    }

    private fun getRumahSakit() {
        api.data_rumahsakit().enqueue(object : Callback<HospitalModel> {
            override fun onFailure(call: Call<HospitalModel>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }

            override fun onResponse(
                call: Call<HospitalModel>,
                response: Response<HospitalModel>
            ) {
                if (response.isSuccessful){
                    val listData = response.body()!!.rumahsakit
                    hospitalAdapter.setData(listData)
                }
            }
        })
    }
}