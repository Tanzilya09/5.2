package com.example.a52.models.location

import com.google.gson.annotations.SerializedName

data class LocationModel (

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String

    )