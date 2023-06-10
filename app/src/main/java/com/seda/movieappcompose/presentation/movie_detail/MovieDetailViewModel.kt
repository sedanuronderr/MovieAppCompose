package com.seda.movieappcompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seda.movieappcompose.domain.use_case.get_detail.GetMovieDetailUseCase
import com.seda.movieappcompose.presentation.movie_list.MoviesState
import com.seda.movieappcompose.util.Constants
import com.seda.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,    private val stateHandle:SavedStateHandle):ViewModel() {

   private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
   val state :State<MovieDetailState> = _state



    init {
        stateHandle.get<String>(Constants.IMDB_ID).let {
            if (it != null) {
                getMovieDetail(it)
            }
        }

    }


   private fun getMovieDetail(imdbId:String){

  getMovieDetailUseCase.executeGetMovieDetail(imdbId = imdbId).onEach {
      when(it){
          is Resource.Success -> {
              _state.value = MovieDetailState(movie = it.data )
          }

          is Resource.Error -> {
              _state.value = MovieDetailState(error = it.message ?: "Error!")
          }

          is Resource.Loading -> {
              _state.value = MovieDetailState(isLoading = true)
          }
      }
  }.launchIn(viewModelScope)


   }

}