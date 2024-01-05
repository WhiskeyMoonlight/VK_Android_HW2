package com.example.hw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class GifAdapter(private val urls: List<String>) : RecyclerView.Adapter<GifAdapter.GifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gif_item, parent, false)
        return GifViewHolder(view)
    }

    override fun getItemCount(): Int = urls.size

    override fun onBindViewHolder(
        holder: GifViewHolder,
        position: Int
    ) = holder.bind(urls[position])

    class GifViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: String) {
            val iv = view.findViewById<ImageView>(R.id.iv_gif)
            Glide.with(view)
                .load(item)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv)
        }
    }
}