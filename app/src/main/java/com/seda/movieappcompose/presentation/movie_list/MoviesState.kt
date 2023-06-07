package com.seda.movieappcompose.presentation.movie_list

import com.seda.movieappcompose.domain.model.Movie


data class MoviesState (
    val isLoading: Boolean = false,
    val movies:List<Movie> = emptyList(),
    val error :String = "",
    val search :String =""

        )