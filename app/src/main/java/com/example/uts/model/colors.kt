package com.example.uts.model


import com.google.gson.annotations.SerializedName

data class colors(
    @SerializedName("color")
    val color: List<Color>
)