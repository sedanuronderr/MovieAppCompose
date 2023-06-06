package com.seda.movieappcompose.data.remote

import com.seda.movieappcompose.data.remote.dto.MoviesDetailDto
import com.seda.movieappcompose.data.remote.dto.MoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {


    @GET("?apikey=fbdd89ef")
    suspend fun getFilm(
        @Query("s") search:String
    ): Response<MoviesDto>

    @GET("?apikey=fbdd89ef")
    suspend fun getMovie(
        @Query("i") movieId: String,
    ): Response<MoviesDetailDto>
}