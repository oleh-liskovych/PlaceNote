package com.olehliskovych.placenote.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index

@Entity(tableName = "note_label_join",
        primaryKeys = ["note_id", "label_id"],
        foreignKeys = [
            ForeignKey(
                    entity = Note::class,
                    parentColumns = ["id"],
                    childColumns = ["note_id"]
            ),
            ForeignKey(
                    entity = Label::class,
                    parentColumns = ["id"],
                    childColumns = ["label_id"]
            )
        ],
        indices = [
            Index("label_id")])
data class NoteLabelJoin(
        @ColumnInfo(name = "note_id")
        var noteId: Long,
        @ColumnInfo(name = "label_id")
        var labelId: Long
) {

}