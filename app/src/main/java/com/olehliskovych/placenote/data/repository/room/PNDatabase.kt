package com.olehliskovych.placenote.data.repository.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note
import com.olehliskovych.placenote.data.entities.NoteLabelJoin
import com.olehliskovych.placenote.data.repository.room.daos.LabelDao
import com.olehliskovych.placenote.data.repository.room.daos.NoteDao
import com.olehliskovych.placenote.data.repository.room.daos.NoteLabelJoinDao
import com.olehliskovych.placenote.utils.SingletonHolder

@Database(entities = [Note::class, Label::class, NoteLabelJoin::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
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