package com.example.selfhealth_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class HospitalAdapter(val listHospitals: ArrayList<Hospitals>) : RecyclerView.Adapter<HospitalAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail)
        var tvCity: TextView = itemView.findViewById(R.id.tv_city)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_hospital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hospitals, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHospitals.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hospital = listHospitals[position]
        Glide.with(holder.itemView.context)
            .load(hospital.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = hospital.name
        holder.tvDetail.text = hospital.detail
        holder.tvCity.text = hospital.city
    }

}