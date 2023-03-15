package com.example.a52.models.character

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("gender")
    val gender: String

)
