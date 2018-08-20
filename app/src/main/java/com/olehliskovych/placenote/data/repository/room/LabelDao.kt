package com.olehliskovych.placenote.data.repository.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import com.olehliskovych.placenote.data.entities.Label

@Dao
interface LabelDao {

    @Insert
    fun insertLabel(label: Label)

    @Update
    fun updateLabel(label: Label)

    @Delete
    fun deleteLabel(vararg label: Label)
}