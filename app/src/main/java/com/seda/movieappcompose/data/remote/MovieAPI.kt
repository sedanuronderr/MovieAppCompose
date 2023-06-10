package com.seda.movieappcompose.data.remote

import com.seda.movieappcompose.data.remote.dto.MoviesDetailDto
import com.seda.movieappcompose.data.remote.dto.MoviesDto
import com.seda.movieappcompose.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {


    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString :String,
        @Query("apikey") apiKey :String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMoviesDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MoviesDetailDto

}