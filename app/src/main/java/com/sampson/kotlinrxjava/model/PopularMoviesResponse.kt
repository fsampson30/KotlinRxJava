package com.sampson.kotlinrxjava.model

data class PopularMoviesResponse(
    val page : Int,
    val results: List<Movie>
)
