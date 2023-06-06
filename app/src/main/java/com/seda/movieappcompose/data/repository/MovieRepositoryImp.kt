package com.seda.movieappcompose.data.repository

import com.seda.movieappcompose.data.remote.MovieAPI
import com.seda.movieappcompose.data.remote.dto.MoviesDetailDto
import com.seda.movieappcompose.data.remote.dto.MoviesDto
import com.seda.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val api:MovieAPI) : MovieRepository {
  override suspend fun getMovies(search: String): MoviesDto {
             return api.getFilm(search = search)
  }

  override suspend fun getMovieDetail(imdbId: String): MoviesDetailDto {

       return api.getMovie(movieId = imdbId)
  }
 }