package com.sampson.kotlinrxjava.api

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "22fff89ba91cea9db070ea96e0aa4451"

    fun fetchMovies() = movieService.getPopularMovies(apiKey)
}