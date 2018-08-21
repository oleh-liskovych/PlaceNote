package com.olehliskovych.placenote.data.repository.room.daos

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.olehliskovych.placenote.data.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY update_date DESC")
    fun getNotesByDateDESC(): DataSource.Factory<Int, Note>

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(vararg note: Note)
}