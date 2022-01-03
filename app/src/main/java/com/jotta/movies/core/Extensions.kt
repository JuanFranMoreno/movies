package com.jotta.movies.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (T) -> Unit){
    liveData.observe(this, Observer(observer))
}

inline fun <reified T : Activity> Context.startActivity(vararg pairs: Pair<String, Any?>){
    val intent = Intent(this, T::class.java)
    intent.putExtras(bundleOf(*pairs))
    startActivity(intent)
}