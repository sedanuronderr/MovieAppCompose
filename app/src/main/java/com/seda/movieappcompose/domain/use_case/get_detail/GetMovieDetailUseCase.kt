package com.seda.movieappcompose.domain.use_case.get_detail

import com.seda.movieappcompose.data.remote.dto.toMovieDetaail
import com.seda.movieappcompose.data.remote.dto.toMovieList
import com.seda.movieappcompose.domain.model.Movie
import com.seda.movieappcompose.domain.model.MovieDetail
import com.seda.movieappcompose.domain.repository.MovieRepository
import com.seda.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase  @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbId:String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)

                emit(Resource.Success(movieDetail.toMovieDetaail()))

        }catch (e: IOError){
            emit(Resource.Error(message = "No internet connection"))

        }

    }
}