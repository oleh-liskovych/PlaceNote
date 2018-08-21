package com.olehliskovych.placenote.data.repository.room.daos

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.olehliskovych.placenote.data.entities.Label

@Dao
interface LabelDao {

    @Query("SELECT * FROM labels ORDER BY update_date DESC")
    fun getLabelsByDateDESC(): DataSource.Factory<Int, Label>

    @Insert
    fun insertLabel(label: Label)

    @Update
    fun updateLabel(label: Label)

    @Delete
    fun deleteLabel(vararg label: Label)
}