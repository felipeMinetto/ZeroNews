package com.fsm.zeronews.data.api.di

import com.fsm.zeronews.BuildConfig
import com.fsm.zeronews.data.api.API
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL: String = "https://newsapi.org"

    /**
     * Provides a Retrofit object configured with the [HttpLoggingInterceptor] and Api key in the header.
     */
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("X-Api-Key", BuildConfig.API_KEY)
                    .build()
                chain.proceed(request)
            }
            .build()
        val moshi = Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }

    /**
     * Using the [Retrofit] object to provide an [API] object.
     */
    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }
}