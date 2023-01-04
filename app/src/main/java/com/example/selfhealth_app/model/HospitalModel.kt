package com.example.selfhealth_app.model

data class HospitalModel (val rumahsakit: List<Data>) {
    data class Data (val id: String?, val nama: String?, val alamat: String?, val kota: String?)
}