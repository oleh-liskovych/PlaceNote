package com.olehliskovych.placenote.data.repository.room

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.olehliskovych.placenote.data.entities.Note
import com.olehliskovych.placenote.data.entities.NoteLabelJoin

@Dao
interface NoteLabelJoinDao {

    @Insert
    fun insert(noteLabelJoin: NoteLabelJoin)

    @Query("SELECT * FROM notes INNER JOIN note_label_join ON notes.id=note_label_join.note_id WHERE note_label_join.label_id = :labelId")
    fun getNotesForLabel(labelId: Long) : DataSource.Factory<Int, Note>

    @Query("SELECT * FROM labels INNER JOIN note_label_join ON labels.id=note_label_join.label_id WHERE note_label_join.note_id = :noteId")
    fun getLabelsForNote(noteId: Long) : DataSource.Factory<Int, Note>
}