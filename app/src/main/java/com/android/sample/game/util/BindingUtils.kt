package com.android.sample.game.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.android.sample.game.R
import com.android.sample.game.adapter.GifAdapter
import com.android.sample.game.model.WrapperResponse
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, gifUrl: String) {
    val circularProgressDrawable = CircularProgressDrawable(imageView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(imageView.context)
        .load(gifUrl)
        .placeholder(circularProgressDrawable)
        .into(imageView)
}

@BindingAdapter("items")
fun submitList(recyclerView: RecyclerView, resource: Resource<WrapperResponse>?) {
    if (resource is Resource.Success) {
        recyclerView.visibility = View.VISIBLE
        (recyclerView.adapter as GifAdapter).submitList(resource.data?.wrapper)
    } else {
        recyclerView.visibility = View.INVISIBLE
    }
}

@BindingAdapter("showLoading")
fun <T> View.showLoading(resource: Resource<T>?) {
    visibility = if (resource is Resource.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("showError")
fun <T> View.showError(resource: Resource<T>?) {
    visibility = if (resource is Resource.Error) View.VISIBLE else View.GONE
}