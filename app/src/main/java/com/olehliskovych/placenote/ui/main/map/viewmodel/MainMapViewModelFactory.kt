package com.olehliskovych.placenote.ui.main.map.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.olehliskovych.placenote.data.repository.Repository
import javax.inject.Inject

class MainMapViewModelFactory @Inject constructor(var repo: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainMapViewModel(repo) as T
    }

}