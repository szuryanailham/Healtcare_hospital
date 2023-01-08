package com.example.selfhealth_app.api

import com.example.selfhealth_app.model.HospitalModel
import com.example.selfhealth_app.model.PatientModel
import com.example.selfhealth_app.model.RoomModel
import com.example.selfhealth_app.model.SubmitModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @GET("data_rumahsakit.php")
    fun data_rumahsakit() : Call<HospitalModel>

    @GET("data_kamar.php")
    fun data_kamar() : Call<RoomModel>

    @GET("data_pasien.php")
    fun data_pasien() : Call<PatientModel>

    @FormUrlEncoded
    @POST("create_pasien.php")
    fun create(
        @Field("no_pasien") number: String,
        @Field("nama") name: String,
        @Field("ttl") born: String,
        @Field("jenis_kelamin") gender: String,
        @Field("alamat") address: String,
        @Field("keluhan") complaint: String,
        @Field("kamar") room: String,
    ) : Call<SubmitModel>


}
