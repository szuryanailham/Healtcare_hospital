package com.example.selfhealth_app.api

import com.example.selfhealth_app.model.HospitalModel
import com.example.selfhealth_app.model.RoomModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data_rumahsakit.php")
    fun data_rumahsakit() : Call<HospitalModel>

    @GET("data_kamar.php")
    fun data_kamar() : Call<RoomModel>


}
