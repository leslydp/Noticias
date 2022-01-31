package com.orlandev.noticias.data.source.remote

import com.orlandev.noticias.data.source.remote.dto.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiasApi {
    companion object {
        const val API_BASE_URL = "https://hn.algolia.com/"
    }

    @GET("api/v1/search_by_date")
    suspend fun fetchNoticiasDTO(@Query("query") lang: String = "mobile"): News



}