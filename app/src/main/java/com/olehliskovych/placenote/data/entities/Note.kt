package com.olehliskovych.placenote.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.util.*

@Entity(tableName = "notes")
data class Note(
        @PrimaryKey(autoGenerate = true) var id: Long,
        var title: String = "",
        var message: String = "",
        var radius: Int = 100,
        var latitude: Double = 0.toDouble(),
        var longitude: Double = 0.toDouble(),
        var updateDate: Date = Date()
) : Parcelable {
//        var labels: RealmList<Label> = RealmList(),
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readDouble(),
            Date(parcel.readLong())) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(message)
        parcel.writeInt(radius)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeLong(updateDate.time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}

