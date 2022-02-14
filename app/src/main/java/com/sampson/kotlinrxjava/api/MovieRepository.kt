package com.sampson.kotlinrxjava.api

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "apykey"

    fun fetchMovies() = movieService.getPopularMovies(apiKey)
}