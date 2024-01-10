package com.example.bulbyandex.data.api

import android.provider.ContactsContract.Data
import com.example.bulbyandex.data.DataColor
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>
    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>
    @GET("state/")
    suspend fun getState(): Response<Boolean>
    @GET("color/names_only")
    suspend fun getColors(): Response<List<String>>
    @GET("color/current")
    suspend fun getCurrentColor(): Response<DataColor>
    @FormUrlEncoded
    @POST("color/")
    suspend fun setColor(@Field("color") color: String): Response<Boolean>
    @FormUrlEncoded
    @POST("brightness/")
    suspend fun setBrightness(@Field("level") level: Int): Response<Boolean>
    @GET("brightness/current")
    suspend fun getCurrentBrightness(): Response<Int>
}