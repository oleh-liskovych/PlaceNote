package com.olehliskovych.placenote.data.Repository

import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note

import io.reactivex.Completable
import io.reactivex.Flowable

interface Repository {
    val allLabels: Flowable<List<Label>>
    fun getNotesForLabel(label: Label?): Flowable<List<Note>>
    fun updateNote(note: Note): Completable
    fun updateLabel(label: Label): Completable
    fun deleteNote(note: Note): Completable
    fun deleteLabel(label: Label): Completable
}
