package com.olehliskovych.placenote.data.repository.room

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY updateDate DESC")
    fun getNotesNotesForLabel(label: Label?): DataSource.Factory<Int, Note>

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(vararg note: Note)
}