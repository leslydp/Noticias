package com.orlandev.noticias.data.source.repository

import com.orlandev.noticias.data.source.remote.NoticiasApi
import com.orlandev.noticias.data.source.remote.dto.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class NoticiasRepository @Inject constructor(val noticiasApi: NoticiasApi) {
    suspend fun fetchAll(): News {
        return withContext(Dispatchers.IO){ noticiasApi.fetchNoticiasDTO() }

    }
}