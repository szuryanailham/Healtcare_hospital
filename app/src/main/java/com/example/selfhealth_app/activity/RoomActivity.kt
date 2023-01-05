package com.example.selfhealth_app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.api.ApiRetrofit
import com.example.selfhealth_app.R
import com.example.selfhealth_app.adapter.RoomAdapter
import com.example.selfhealth_app.model.RoomModel
import kotlinx.android.synthetic.main.activity_room.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var roomAdapter: RoomAdapter
    private lateinit var listKamar: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        setupList()

        patientReg.setOnClickListener() {
            Intent(this, RegistrationPatientActivity::class.java).also {
                startActivity(it)
            }
        }

        buttonBack.setOnClickListener(){
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        getKamar()
    }

    private fun setupList() {
        listKamar = findViewById(R.id.list_room)
        roomAdapter = RoomAdapter(arrayListOf())
        listKamar.adapter = roomAdapter
    }

    private fun getKamar() {
        api.data_kamar().enqueue(object : Callback<RoomModel> {
            override fun onFailure(call: Call<RoomModel>, t: Throwable) {
                Log.e("RoomActivity", t.toString())
            }

            override fun onResponse(call: Call<RoomModel>, response: Response<RoomModel>
            ) {
                if (response.isSuccessful){
                    val listData = response.body()!!.kamar
                    roomAdapter.setData(listData)
                }
            }
        })
    }
}