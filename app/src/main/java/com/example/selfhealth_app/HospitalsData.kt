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
        "Jl. Kesehatan Sendowo No.1, Sendowo, Sinduadi, Kec. Mlati",
        "Jl. KH. Ahmad Dahlan No.20, Ngupasan, Kec. Gondomanan",
        "Jl. Cik Di Tiro No.30, Samirono, Terban, Kec. Gondokusuman",
        "Jl. Ki Ageng Pemanahan No.1-6, Sorosutan, Kec. Umbulharjo",
        "Jl. Jend. Sudirman No.70, Kotabaru, Kec. Gondokusuman"
    )

    private val hospitalCity = arrayOf(
        "Sleman, DI Yogyakarta",
        "Yogyakarta, DI Yogyakarta",
        "Yogyakarta, DI Yogyakarta",
        "Yogyakarta, DI Yogyakarta",
        "Yogyakarta, DI Yogyakarta",
    )


    val listData: ArrayList<Hospitals>
        get() {
            val list = arrayListOf<Hospitals>()
            for (position in hospitalNames.indices) {
                val hospitals = Hospitals()
                hospitals.name = hospitalNames[position]
                hospitals.detail = hospitalDetails[position]
                hospitals.city = hospitalCity[position]
                list.add(hospitals)
            }
            return list
        }
}