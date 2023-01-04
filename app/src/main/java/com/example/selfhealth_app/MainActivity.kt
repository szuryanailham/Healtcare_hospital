package com.example.selfhealth_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.adapter.RumahSakitAdapter
import com.example.selfhealth_app.model.RumahSakitModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var rumahSakitAdapter: RumahSakitAdapter
    private lateinit var listRumahsakit: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getRumahSakit()
    }

    private fun setupList() {
        listRumahsakit = findViewById(R.id.list_hospital)
        rumahSakitAdapter = RumahSakitAdapter(arrayListOf())
        listRumahsakit.adapter = rumahSakitAdapter
    }

    private fun getRumahSakit() {
        api.data_rumahsakit().enqueue(object : Callback<RumahSakitModel> {
            override fun onResponse(
                call: Call<RumahSakitModel>,
                response: Response<RumahSakitModel>
            ) {
                if (response.isSuccessful){
                    val listData = response.body()!!.rumahsakit
                    rumahSakitAdapter.setData(listData)
                }
            }

            override fun onFailure(call: Call<RumahSakitModel>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }

        })
    }
}