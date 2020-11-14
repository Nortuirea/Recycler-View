package com.example.uts.model


import com.google.gson.annotations.SerializedName

data class Color(
    @SerializedName("color")
    val color: String,
    @SerializedName("rgb")
    val rgb: List<Int>
)