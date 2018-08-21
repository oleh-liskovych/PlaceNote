package com.olehliskovych.placenote.ui.main.list.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.olehliskovych.placenote.data.repository.Repository
import javax.inject.Inject

class MainListViewModelFactory @Inject constructor(var repo: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainListViewModel(repo) as T
    }

}