package com.olehliskovych.placenote.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.util.*


@Entity(tableName = "labels",
        foreignKeys = [
    ForeignKey(
            entity = Note::class,
            parentColumns = ["id"],
            childColumns = ["note_id"],
            onDelete = CASCADE
    )
])
data class Label(
        @PrimaryKey(autoGenerate = true) var id: Long,
        var name: String = "",
        @ColumnInfo(name = "update_date")
        var updateDate: Date = Date(),
        @ColumnInfo(name = "note_id")
        var noteId: Long? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            Date(parcel.readLong())) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeLong(updateDate.time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Label> {
        override fun createFromParcel(parcel: Parcel): Label {
            return Label(parcel)
        }

        override fun newArray(size: Int): Array<Label?> {
            return arrayOfNulls(size)
        }
    }


}
