package com.example.a52.data.network.apiservice

import com.example.a52.models.location.LocationModel
import com.example.a52.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchLocations(): Call<RickAndMortyResponse<LocationModel>>

}