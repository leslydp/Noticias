package com.orlandev.noticias.data.source.remote.dto

data class Title(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)