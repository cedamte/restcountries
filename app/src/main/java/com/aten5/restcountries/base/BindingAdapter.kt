package com.aten5.restcountries.base

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aten5.restcountries.R
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imgUrl: String) {

    val uri: Uri = Uri.parse(imgUrl)

    GlideApp.with(view.context)
        .`as`(PictureDrawable::class.java)
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_baseline_broken_image_24)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .transition(DrawableTransitionOptions.withCrossFade())
        .listener(SvgSoftwareLayerSetter())
        .load(uri)
        .into(view)
}
