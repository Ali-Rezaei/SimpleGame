package com.android.sample.game.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, gifUrl: String) {
    Glide.with(imageView.context).load(gifUrl).into(imageView)
}