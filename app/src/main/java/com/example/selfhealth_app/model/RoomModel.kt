package com.example.selfhealth_app.model

data class RoomModel (val kamar: List<Data>) {
    data class Data (val id: String?, val nama: String?, val deskripsi: String?)
}