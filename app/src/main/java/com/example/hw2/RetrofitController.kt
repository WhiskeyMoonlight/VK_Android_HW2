package com.example.hw2

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.time.measureTime


object RetrofitController {
    private val scope = CoroutineScope(Dispatchers.IO)


    private val client = Retrofit.Builder()
        .baseUrl("https://giphy.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private fun requireService() = client.create(Api::class.java)

    fun loadData(callback: (result: TrendingGifsResponse?, error: Throwable?) -> Unit) {
        var i = 0
        scope.launch {
            repeat(3) {
                try {
                    i++
                    val result = requireService().getTrendingGifs()
                    withContext(Dispatchers.Main) {
                        callback(result, null)
                    }
                } catch (e: Throwable) {
                    if (i == 3) {
                        withContext(Dispatchers.Main) {
                            callback(null, e)
                        }
                    } else {
                        Log.d("DelayTag", "delayed $it")
                        delay(10000L)
                    }
                }
            }
        }
    }
}