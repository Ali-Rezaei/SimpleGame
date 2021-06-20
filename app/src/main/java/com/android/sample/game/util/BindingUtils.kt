package com.android.sample.game.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.sample.game.R
import com.android.sample.game.adapter.GifAdapter
import com.android.sample.game.model.WrapperResponse
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, gifUrl: String) {
    Glide.with(imageView.context)
        .load(gifUrl)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_error)
        .into(imageView)
}

@BindingAdapter("items")
fun submitList(recyclerView: RecyclerView, resource: Resource<WrapperResponse>?) {
    if (resource is Resource.Success) {
        (recyclerView.adapter as GifAdapter).submitList(resource.data?.wrapper)
    }
}

@BindingAdapter("showLoading")
fun <T> View.showLoading(resource: Resource<T>?) {
    visibility = if (resource is Resource.Loading) View.VISIBLE else View.GONE
}