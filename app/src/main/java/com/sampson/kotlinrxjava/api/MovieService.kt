package com.sampson.kotlinrxjava.api

import com.sampson.kotlinrxjava.model.PopularMoviesResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<PopularMoviesResponse>

}