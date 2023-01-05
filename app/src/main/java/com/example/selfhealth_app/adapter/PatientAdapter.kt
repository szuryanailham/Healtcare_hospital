package com.example.selfhealth_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.R
import com.example.selfhealth_app.model.PatientModel

class PatientAdapter (
    val pasien: ArrayList<PatientModel.Data>
        ) :RecyclerView.Adapter<PatientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_patient, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = pasien[position]
        holder.namaPasien.text = data.nama
        holder.alamatPasien.text = data.alamat
        holder.kamarPasien.text = data.kamar
    }

    override fun getItemCount() = pasien.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaPasien = view.findViewById<TextView>(R.id.nama_pasien)
        val alamatPasien = view.findViewById<TextView>(R.id.alamat_pasien)
        val kamarPasien = view.findViewById<TextView>(R.id.kamar_pasien)
    }

    public fun setData(data: List<PatientModel.Data>) {
        pasien.clear()
        pasien.addAll(data)
        notifyDataSetChanged()
    }


}