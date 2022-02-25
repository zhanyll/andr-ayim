package com.example.andrayim

data class Response(
    val episodes: List<Episode>
)

data class Episode(
    val episode_id: Long?,
    val title: String,
    val season: String,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val series: String
)
