package com.example.a52.data.network.apiservice

import com.example.a52.models.episode.EpisodeModel
import com.example.a52.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisodes(): Call<RickAndMortyResponse<EpisodeModel>>

}