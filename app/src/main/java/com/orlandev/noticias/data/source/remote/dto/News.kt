package com.orlandev.noticias.data.source.remote.dto

data class News(
    val exhaustiveNbHits: Boolean,
    val exhaustiveTypo: Boolean,
    val hits: List<Hit>,
    val hitsPerPage: Int,
    val nbHits: Int,
    val nbPages: Int,
    val page: Int,
    val params: String,
    val processingTimeMS: Int,
    val query: String
)