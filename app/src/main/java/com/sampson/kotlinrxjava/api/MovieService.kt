package com.sampson.kotlinrxjava.api

import com.sampson.kotlinrxjava.model.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<PopularMovieResponse>

}