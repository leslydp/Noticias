package com.orlandev.noticias.module

import com.orlandev.noticias.data.source.remote.NoticiasApi
import com.orlandev.noticias.data.source.repository.NoticiasRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Di {

    @Provides
    @Singleton
    fun provideNoticiasApiService(): NoticiasApi {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val defaultHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(NoticiasApi.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(defaultHttpClient)
            .build()
            .create(NoticiasApi::class.java)
    }

    fun provideRepository(noticiasApi: NoticiasApi): NoticiasRepository {
        return NoticiasRepository(noticiasApi = noticiasApi)
    }
}