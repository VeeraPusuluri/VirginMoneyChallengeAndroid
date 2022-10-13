package com.example.virginmoneychallengeandroid

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setAvatarForEmployee")
fun setAvatarForEmployee(imageView:ImageView,url:String){
    Glide
        .with(imageView.context)
        .load(url)
        .error(R.drawable.ic_launcher_foreground)
        .into(imageView)
}