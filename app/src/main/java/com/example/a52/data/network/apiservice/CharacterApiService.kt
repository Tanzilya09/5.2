package com.example.a52.data.network.apiservice

import com.example.a52.models.RickAndMortyResponse
import com.example.a52.models.character.CharacterModel
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): retrofit2.Call<RickAndMortyResponse<CharacterModel>>

}