package com.example.hw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class GifAdapter(private val items: List<Image>) : RecyclerView.Adapter<GifAdapter.GifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gif_item, parent, false)
        return GifViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
        holder: GifViewHolder,
        position: Int
    ) = holder.bind(items[position])

    class GifViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Image) {
            val iv = view.findViewById<ImageView>(R.id.iv_gif)
            Glide.with(view).load(item.original.url).into(iv)
        }
    }
}