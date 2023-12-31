package com.dicoding.rosterseagames

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListRosterAdapter(private val listRoster: ArrayList<Roster>) : RecyclerView.Adapter<ListRosterAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_roster, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listRoster[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvDescription.text = description

//        Mengirim data ke detail
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("detail_roster", listRoster[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listRoster.size


}