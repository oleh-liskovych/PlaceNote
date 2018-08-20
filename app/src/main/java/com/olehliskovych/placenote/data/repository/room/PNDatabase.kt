package com.olehliskovych.placenote.data.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note
import com.olehliskovych.placenote.utils.SingletonHolder

@Database(entities = [Note::class, Label::class], version = 1)
abstract class PNDatabase : RoomDatabase() {

    abstract fun LabelDao() : LabelDao
    abstract fun NoteDao() : NoteDao
    abstract fun NoteLabelJoinDao() : NoteLabelJoinDao

    companion object : SingletonHolder<PNDatabase, Context> ({
        Room.databaseBuilder(it.applicationContext,
                PNDatabase::class.java, "pnDatabase.db")
                .build()
    })

}