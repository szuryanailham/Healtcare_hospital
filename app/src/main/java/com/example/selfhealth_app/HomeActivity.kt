package com.example.selfhealth_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var list: ArrayList<Hospitals> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvHospitals.setHasFixedSize(true)

        list.addAll(HospitalsData.listData)
        showRecycler()
    }

    private fun showRecycler() {
        rvHospitals.layoutManager = LinearLayoutManager(this)
        val hospitalAdapter = HospitalAdapter(list)
        rvHospitals.adapter = hospitalAdapter
    }
}