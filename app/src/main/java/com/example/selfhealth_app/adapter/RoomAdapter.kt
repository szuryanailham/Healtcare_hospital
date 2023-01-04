package com.example.selfhealth_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.selfhealth_app.R
import com.example.selfhealth_app.model.RoomModel

class RoomAdapter (
    val kamar: ArrayList<RoomModel.Data>
        ) :RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_room, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = kamar[position]
        holder.textNama.text = data.nama
        holder.textDeskripsi.text = data.deskripsi
    }

    override fun getItemCount() = kamar.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNama = view.findViewById<TextView>(R.id.nama_kamar)
        val textDeskripsi = view.findViewById<TextView>(R.id.detail_kamar)
    }

    public fun setData(data: List<RoomModel.Data>) {
        kamar.clear()
        kamar.addAll(data)
        notifyDataSetChanged()
    }


}