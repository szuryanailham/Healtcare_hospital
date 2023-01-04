package com.example.selfhealth_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.R
import com.example.selfhealth_app.model.HospitalModel

class HospitalAdapter(
    val rumahsakit: ArrayList<HospitalModel.Data>
    ) :RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_hospitals, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = rumahsakit[position]
        holder.textNama.text = data.nama
        holder.textAlamat.text = data.alamat
        holder.textKota.text = data.kota
    }

    override fun getItemCount() = rumahsakit.size

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textNama = view.findViewById<TextView>(R.id.text_nama)
        val textAlamat = view.findViewById<TextView>(R.id.text_alamat)
        val textKota = view.findViewById<TextView>(R.id.text_kota)
    }

    public fun setData(data: List<HospitalModel.Data>) {
        rumahsakit.clear()
        rumahsakit.addAll(data)
        notifyDataSetChanged()
    }
}