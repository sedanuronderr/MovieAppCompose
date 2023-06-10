package com.seda.movieappcompose.presentation.movie_detail

import com.seda.movieappcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading:Boolean =false,
    val movie: MovieDetail? = null,
    val error:String=""

)
