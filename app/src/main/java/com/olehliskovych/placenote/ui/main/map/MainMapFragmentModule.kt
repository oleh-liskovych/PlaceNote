package com.olehliskovych.placenote.ui.main.map

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.olehliskovych.placenote.data.repository.IRepository
import com.olehliskovych.placenote.data.repository.Repository
import com.olehliskovych.placenote.di.scopes.FragmentScope
import com.olehliskovych.placenote.ui.main.map.viewmodel.MainMapViewModel
import com.olehliskovych.placenote.ui.main.map.viewmodel.MainMapViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface MainMapFragmentModule {


    @FragmentScope
    @Binds
    fun bindViewModelProviderFactory(factory: MainMapViewModelFactory) : ViewModelProvider.Factory

    @FragmentScope
    @Binds
    fun bindMainRepository(mainRepository: Repository) : IRepository

    @FragmentScope
    @Binds
    fun bindMainViewModel(mainViewModel: MainMapViewModel) : ViewModel
}