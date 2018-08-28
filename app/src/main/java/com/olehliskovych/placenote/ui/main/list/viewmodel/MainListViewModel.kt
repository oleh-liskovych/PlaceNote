package com.olehliskovych.placenote.ui.main.list.viewmodel

import com.olehliskovych.placenote.data.repository.IRepository
import com.olehliskovych.placenote.ui.base.BaseViewModel
import javax.inject.Inject

class MainListViewModel @Inject constructor(repository: IRepository)
    :BaseViewModel<IRepository>(repository) {

}