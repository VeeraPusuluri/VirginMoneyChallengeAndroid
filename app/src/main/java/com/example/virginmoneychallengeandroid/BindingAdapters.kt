package com.example.virginmoneychallengeandroid

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setAvatarForEmployee")
fun setAvatarForEmployee(imageView:ImageView,url:String){
    Glide.with(imageView.context).load(url).into(imageView)
}