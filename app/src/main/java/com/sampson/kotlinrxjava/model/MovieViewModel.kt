package com.sampson.kotlinrxjava.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sampson.kotlinrxjava.api.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val popularMoviesLiveData = MutableLiveData<List<Movie>>()
    private val errorLiveData = MutableLiveData<String>()

    val popularMovies: LiveData<List<Movie>>
        get() = popularMoviesLiveData

    val error: LiveData<String>
        get() = errorLiveData

    private var disposable = CompositeDisposable()

    fun fetchPopularMovies() {
        disposable.add(movieRepository.fetchMovies()
            .subscribeOn(Schedulers.io())
            .map { it.results }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                popularMoviesLiveData.postValue(it)
            }, { error ->
                Log.d("MovieViewModel", "error encountered: ${error.localizedMessage}")
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }


}

