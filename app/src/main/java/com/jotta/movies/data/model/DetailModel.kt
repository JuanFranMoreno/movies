package com.jotta.movies.data.model

import com.google.gson.annotations.SerializedName

data class DetailModel(
    @SerializedName("poster_path") val posterPath:String,
    @SerializedName("title") val title:String,
    @SerializedName("overview") val overview:String,

)