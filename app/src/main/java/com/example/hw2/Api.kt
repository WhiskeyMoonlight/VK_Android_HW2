package com.example.hw2

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {

    @GET("/v1/gifs/trending")
    suspend fun getTrendingGifs(
        @Header("X-RapidAPI-Key") key: String = KEY,
        @Header("X-RapidAPI-Host") host: String = HOST,
        @Query("api_key") apiKey: String = API_KEY,
    ): TrendingGifsResponse

    companion object {
        const val KEY = "cc99a93c0emsha90bff4e860149fp176238jsn8d83b59a1f93"
        const val HOST = "giphy.p.rapidapi.com"
        const val API_KEY = "fXPzt5bNbYQyD8kV0FAdugvymXj0ajb4"
    }
}