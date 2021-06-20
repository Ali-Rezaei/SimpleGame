package com.android.sample.game.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.sample.game.databinding.GifItemBinding
import com.android.sample.game.model.DataResponse
import com.android.sample.game.util.layoutInflater

class GifAdapter : ListAdapter<DataResponse, GifAdapter.MainViewHolder>(DiffCallback) {

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder.from(parent)

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * ViewHolder for category items. All work is done by data binding.
     */
    class MainViewHolder(private val binding: GifItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataResponse: DataResponse) {
            binding.dataResponse = dataResponse
        }

        companion object {
            fun from(parent: ViewGroup): MainViewHolder {
                val binding = GifItemBinding.inflate(
                    parent.context.layoutInflater,
                    parent,
                    false
                )
                return MainViewHolder(binding)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [DataResponse]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<DataResponse>() {
        override fun areItemsTheSame(oldItem: DataResponse, newItem: DataResponse): Boolean {
            return oldItem.images.original.gifUrl == newItem.images.original.gifUrl
        }

        override fun areContentsTheSame(oldItem: DataResponse, newItem: DataResponse): Boolean {
            return oldItem == newItem
        }
    }
}