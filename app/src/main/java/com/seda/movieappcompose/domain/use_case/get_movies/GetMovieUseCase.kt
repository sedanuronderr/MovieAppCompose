package com.seda.movieappcompose.domain.use_case.get_movies

import com.seda.movieappcompose.data.remote.dto.toMovieList
import com.seda.movieappcompose.domain.model.Movie
import com.seda.movieappcompose.domain.repository.MovieRepository
import com.seda.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search:String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
         val movieList = repository.getMovies(search)
             if(movieList.Response.equals("True")){
            emit(Resource.Success(movieList.toMovieList()))
             }else{
                 emit(Resource.Error(message = "no movie found"))
             }
        }catch (e: IOError){
            emit(Resource.Error(message = "No internet connection"))

        }

    }

}