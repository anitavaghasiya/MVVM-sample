package com.mvvm.mvvmlearnkotlin.ui.dashboard.ui.Wallpaper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvm.mvvmlearnkotlin.model.WallpaperResponseItem
import com.mvvm.mvvmlearnkotlin.databinding.ItemLayoutBinding
import com.mvvm.mvvmlearnkotlin.interfaces.ClickInterface
import javax.inject.Inject

class WallpaperNewAdapter @Inject constructor() : RecyclerView.Adapter<WallpaperNewAdapter.WallpaperViewHolder>() {

    var wallpaperResponseItemMutableList = mutableListOf<WallpaperResponseItem>()
    var clickInterface: ClickInterface<WallpaperResponseItem>? = null

    fun updateMovies(wallpaperResponseItemList: List<WallpaperResponseItem>) {
        this.wallpaperResponseItemMutableList = wallpaperResponseItemList.toMutableList()
        notifyItemRangeInserted(0, wallpaperResponseItemList.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {
        val binding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WallpaperViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        val movie = wallpaperResponseItemMutableList[position]

        //todo uncomment

        Glide
            .with(holder.view.imageViewAvatar.context)
            .load(movie.urls?.regular)
            .centerCrop()
            .into(holder.view.imageViewAvatar)

    }

    override fun getItemCount(): Int {
        return wallpaperResponseItemMutableList.size
    }


    class WallpaperViewHolder(val view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root)
}

