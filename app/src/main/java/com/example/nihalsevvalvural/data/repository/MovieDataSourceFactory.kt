package com.example.nihalsevvalvural.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.nihalsevvalvural.data.vo.Movie
import androidx.paging.DataSource
import com.example.nihalsevvalvural.data.api.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService:TheMovieDBInterface,private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int,Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }

}