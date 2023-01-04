package com.example.selfhealth_app

import com.example.selfhealth_app.model.RumahSakitModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data_rumahsakit.php")
    fun data_rumahsakit() : Call<RumahSakitModel>
}
