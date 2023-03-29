package com.example.hw3_mounth5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.hw3_mounth5.databinding.ItemImageBinding

class ImageAdapter(var list:ArrayList<ImageModel>):Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    fun cleanImage(){
        list.clear()
    }

    override fun getItemCount(): Int {
        return list.count()

    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
      holder.onBind(list[position])
    }
    class ImageViewHolder(var binding: ItemImageBinding) :ViewHolder(binding.root){
        fun onBind(imageModel:ImageModel) {
binding.ImageView.load(imageModel.largeImageURL)
        }

    }
}