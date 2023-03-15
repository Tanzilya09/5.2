package com.example.a52

import android.app.Application
import com.example.a52.data.RetrofitClient
import com.example.a52.data.network.apiservice.CharacterApiService
import com.example.a52.data.network.apiservice.EpisodeApiService
import com.example.a52.data.network.apiservice.LocationApiService

class App : Application() {

    companion object {
        var characterApiService: CharacterApiService? = null
        var episodeApiService: EpisodeApiService? = null
        var locationApiService: LocationApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = RetrofitClient().provideCharacterApiService()
        episodeApiService = RetrofitClient().provideEpisodeApiService()
        locationApiService = RetrofitClient().provideLocationApiService()
    }

}
