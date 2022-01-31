package com.orlandev.noticias.data.source.remote.dto

data class Author(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)