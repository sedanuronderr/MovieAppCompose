package com.seda.movieappcompose.domain.repository

import com.seda.movieappcompose.data.remote.dto.MoviesDetailDto
import com.seda.movieappcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search:String):MoviesDto
    suspend fun getMovieDetail(imdbId:String):MoviesDetailDto

}