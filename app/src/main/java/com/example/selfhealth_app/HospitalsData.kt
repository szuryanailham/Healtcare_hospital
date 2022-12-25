package com.example.selfhealth_app

object HospitalsData {
    private val hospitalNames = arrayOf(
        "RSUP Dr. Sardjito",
        "RS PKU Muhammadiyah Yogyakarta",
        "RS Umum Panti Rapih",
        "RSUD Kota Yogyakarta",
        "RS Bethesda Yogyakarta"
    )

    private val hospitalDetails = arrayOf(
        "Jl. Kesehatan Sendowo No.1, Sendowo, Sinduadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281",
        "Jl. KH. Ahmad Dahlan No.20, Ngupasan, Kec. Gondomanan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55122",
        "Jl. Cik Di Tiro No.30, Samirono, Terban, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55223",
        "Jl. Ki Ageng Pemanahan No.1-6, Sorosutan, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55162",
        "Jl. Jend. Sudirman No.70, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224"
    )

    private val hospitalsImages = intArrayOf(
        R.drawable.sardjito,
        R.drawable.pku,
        R.drawable.pantirapih,
        R.drawable.rsudyogya,
        R.drawable.bethesda
    )

    val listData: ArrayList<Hospitals>
        get() {
            val list = arrayListOf<Hospitals>()
            for (position in hospitalNames.indices) {
                val hospitals = Hospitals()
                hospitals.name = hospitalNames[position]
                hospitals.detail = hospitalDetails[position]
                hospitals.photo = hospitalsImages[position]
                list.add(hospitals)
            }
            return list
        }
}