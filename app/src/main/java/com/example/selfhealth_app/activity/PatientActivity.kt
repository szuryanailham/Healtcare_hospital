package com.example.selfhealth_app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.R
import com.example.selfhealth_app.adapter.PatientAdapter
import com.example.selfhealth_app.api.ApiRetrofit
import com.example.selfhealth_app.model.PatientModel
import kotlinx.android.synthetic.main.activity_room.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var patientAdapter: PatientAdapter
    private lateinit var listPasien: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)
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
        getPasien()
    }

    private fun setupList() {
        listPasien = findViewById(R.id.list_patient)
        patientAdapter = PatientAdapter(arrayListOf(), object : PatientAdapter.OnAdapterListener{
            override fun onClick(pasien: PatientModel.Data) {
                startActivity(Intent(this@PatientActivity, EditPatientActivity::class.java)
                    .putExtra("pasien", pasien)
                )
            }

        })
        listPasien.adapter = patientAdapter
    }

    private fun getPasien() {
        api.data_pasien().enqueue(object : Callback<PatientModel> {
            override fun onFailure(call: Call<PatientModel>, t: Throwable) {
                Log.e("PatientActivity", t.toString())
            }

            override fun onResponse(call: Call<PatientModel>, response: Response<PatientModel>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.pasien
                    patientAdapter.setData(listData)
                }
            }
        })
    }
}