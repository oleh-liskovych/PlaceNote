package com.olehliskovych.placenote.ui.main.map.viewmodel

import com.olehliskovych.placenote.data.repository.IRepository
import com.olehliskovych.placenote.ui.base.BaseRepository
import com.olehliskovych.placenote.ui.base.BaseViewModel
import javax.inject.Inject

class MainMapViewModel @Inject constructor(repository: IRepository)
    : BaseViewModel<IRepository>(repository) {

}