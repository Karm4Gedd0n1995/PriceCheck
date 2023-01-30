package com.example.pricecheck.data.remote

import com.example.pricecheck.data.model.Prospect
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://public.syntax-institut.de/apps/batch4/Frederic/"

const val API_Token = "prospecttoken"

private val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $API_Token")
            .build()
        chain.proceed(newRequest)
    }.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProspectApiService {

    @GET("rewe.json")
    suspend fun getProspects(): List<ProspectApi>

}

object ProspectApi {
    val retrofitService: ProspectApiService by lazy { retrofit.create(ProspectApiService::class.java)}
}