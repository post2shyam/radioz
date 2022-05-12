package com.androidz.radioz.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidz.radioz.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val favoriteStationsMutableLiveData: MutableLiveData<List<String>> =
        MutableLiveData<List<String>>()
    private val _favoriteStationsLiveData: LiveData<List<String>> = favoriteStationsMutableLiveData

    init {
        loadFavoriteStations()
    }

    private fun loadFavoriteStations() {
        viewModelScope.launch(Dispatchers.IO) {
            val favoriteRadioStations = repository.getFavoriteRadioStations()
            when (favoriteRadioStations.isSuccessful) {
                true -> with(favoriteRadioStations.body()) {
                    val favoriteStations = this?.stations ?: emptyList()
                    favoriteStationsMutableLiveData.postValue(favoriteStations)
                }
                else -> {Timber.e("Error invoking rest api")}
            }
        }
    }

    fun getFavoriteStations() = _favoriteStationsLiveData
}