package com.sampson.kotlinrxjava.model

data class PopularMovieResponse(
    val page : Int,
    val results: List<Movie>
)
