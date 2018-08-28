package com.olehliskovych.placenote.ui.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel<R : BaseRepository> constructor(protected val repository: R) : ViewModel() {

}