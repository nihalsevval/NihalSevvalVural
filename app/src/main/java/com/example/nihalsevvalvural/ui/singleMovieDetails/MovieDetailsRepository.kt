package com.example.nihalsevvalvural.ui.singleMovieDetails

import androidx.lifecycle.LiveData
import com.example.nihalsevvalvural.data.api.TheMovieDBInterface
import com.example.nihalsevvalvural.data.repository.MovieDetailsNetworkDataSource
import com.example.nihalsevvalvural.data.repository.NetworkState
import com.example.nihalsevvalvural.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService:TheMovieDBInterface) {
    lateinit var movieDetailsNetworkDataSource:MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable,movieId: Int):LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState():LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }

}