package com.olehliskovych.placenote.data.repository

import android.arch.paging.DataSource
import android.arch.paging.PagedList
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note

import io.reactivex.Completable
import io.reactivex.Flowable

@Deprecated(message = "Not anymore relevant. Split it to interfaces for Map, List and Details ones")
interface IRepository {
    fun getNotesNotesForLabel(label: Label?): DataSource.Factory<Int, Note>
    fun updateNote(note: Note): Completable
    fun insertNote(note: Note): Completable
    fun deleteNote(note: Note): Completable

    fun insertLabel(label: Label): Completable
    fun updateLabel(label: Label): Completable
    fun deleteLabel(label: Label): Completable
}
