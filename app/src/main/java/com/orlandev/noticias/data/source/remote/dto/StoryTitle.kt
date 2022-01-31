package com.orlandev.noticias.data.source.remote.dto

data class StoryTitle(
    val matchLevel: String,
    val matchedWords: List<Any>,
    val value: String
)