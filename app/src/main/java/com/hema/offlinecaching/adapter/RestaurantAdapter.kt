package com.hema.offlinecaching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hema.offlinecaching.data.model.RestaurantModel
import com.hema.offlinecaching.databinding.RestaurantItemBinding

class RestaurantAdapter :
    ListAdapter<RestaurantModel, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparison()) {

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurantModel: RestaurantModel) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurantModel.logo)
                    .into(ivLogo)
                tvName.text = restaurantModel.name
                tvType.text = restaurantModel.type
                tvAddress.text = restaurantModel.address
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}
// to compare between two response
class RestaurantComparison : DiffUtil.ItemCallback<RestaurantModel>() {
    override fun areItemsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
        oldItem == newItem
}
