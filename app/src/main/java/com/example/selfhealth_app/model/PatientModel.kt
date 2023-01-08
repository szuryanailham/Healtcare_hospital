package com.example.selfhealth_app.model

import java.io.Serializable

data class PatientModel (val pasien: List<Data>) {
    data class Data (
            val id: String?,
            val nomor_pasien: String?,
            val nama: String?,
            val ttl: String?,
            val jenis_kelamin: String?,
            val alamat: String?,
            val keluhan: String?,
            val kamar: String?
            ) : Serializable
}