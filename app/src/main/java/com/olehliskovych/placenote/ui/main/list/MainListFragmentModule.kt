package com.olehliskovych.placenote.ui.main.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.olehliskovych.placenote.data.repository.IRepository
import com.olehliskovych.placenote.data.repository.Repository
import com.olehliskovych.placenote.di.scopes.FragmentScope
import com.olehliskovych.placenote.ui.main.list.viewmodel.MainListViewModel
import com.olehliskovych.placenote.ui.main.list.viewmodel.MainListViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface MainListFragmentModule {

    @FragmentScope
    @Binds
    fun bindViewModelProviderFactory(factory: MainListViewModelFactory): ViewModelProvider.Factory

    @FragmentScope
    @Binds
    fun bindListRepository(listRepository: Repository): IRepository

    @FragmentScope
    @Binds
    fun bindListViewModel(listViewModel: MainListViewModel): ViewModel
}