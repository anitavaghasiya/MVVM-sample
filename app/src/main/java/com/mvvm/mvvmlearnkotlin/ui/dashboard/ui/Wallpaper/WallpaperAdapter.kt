package com.mvvm.mvvmlearnkotlin.ui.dashboard.ui.Wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvm.mvvmlearnkotlin.R
import com.mvvm.mvvmlearnkotlin.model.WallpaperResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*


class WallpaperAdapter(private val wallpaperResponseItemArrayList: ArrayList<WallpaperResponseItem>) : RecyclerView.Adapter<WallpaperAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(wallpaper: WallpaperResponseItem) {
            itemView.apply {
                //todo uncomment
                Glide.with(imageViewAvatar.context)
                    .load(wallpaper.urls?.regular)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = wallpaperResponseItemArrayList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(wallpaperResponseItemArrayList[position])
    }

    fun addUsers(wallpaper: List<WallpaperResponseItem>) {
        this.wallpaperResponseItemArrayList.apply {
            clear()
            addAll(wallpaper)
        }

    }
}