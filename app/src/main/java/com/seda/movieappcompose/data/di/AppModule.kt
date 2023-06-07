package com.seda.movieappcompose.data.di

import com.seda.movieappcompose.data.remote.MovieAPI
import com.seda.movieappcompose.data.repository.MovieRepositoryImp
import com.seda.movieappcompose.domain.repository.MovieRepository
import com.seda.movieappcompose.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

@Provides
@Singleton
    fun provideMovieApp():MovieAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideMovieRepository(api:MovieAPI): MovieRepository {
        return MovieRepositoryImp(api)
    }
}