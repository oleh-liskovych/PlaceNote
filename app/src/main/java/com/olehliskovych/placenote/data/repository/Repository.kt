package com.olehliskovych.placenote.data.repository

import android.arch.paging.DataSource
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note
import io.reactivex.Completable
import javax.inject.Inject

class Repository @Inject constructor() : IRepository {
    override fun getNotesNotesForLabel(label: Label?): DataSource.Factory<Int, Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(note: Note): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertNote(note: Note): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertLabel(label: Label): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLabel(label: Label): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteLabel(label: Label): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}