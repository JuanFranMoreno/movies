package com.jotta.mvvm.ui.movie_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jotta.movies.R

class MovieView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val cover: ImageView
    private val title: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_movie, this, true)
        cover = findViewById(R.id.cover)
        title = findViewById(R.id.title)

        orientation = VERTICAL
    }

}