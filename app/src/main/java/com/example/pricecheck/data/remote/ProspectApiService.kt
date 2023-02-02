package com.example.pricecheck.data.remote

import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.data.model.ProspectApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://public.syntax-institut.de/apps/batch4/Frederic/"



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProspectApiService {

    @GET("rewe.json")
    suspend fun getProspects(): List<ProspectApi>

}

object ProspectApiobject {
    val retrofitService: ProspectApiService by lazy { retrofit.create(ProspectApiService::class.java)}
}