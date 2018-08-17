package com.olehliskovych.placenote.data.entities

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Note(
        @PrimaryKey var id: String = UUID.randomUUID().toString(),
        var title: String = "",
        var message: String = "",
        var radius: Int = 100,
        var latitude: Double = 0.toDouble(),
        var longitude: Double = 0.toDouble(),
        var labels: RealmList<Label> = RealmList(),
        var updateDate: Date = Date()
) : RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readDouble(),
            fromNativeToRealmList(parcel.createTypedArrayList(Label.CREATOR)),
            Date(parcel.readLong())) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(message)
        parcel.writeInt(radius)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeTypedList(fromRealmToNativeList(this.labels))
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

        private fun <U> fromNativeToRealmList(raw: List<U>): RealmList<U> {
            val result = RealmList<U>()
            result.addAll(raw)
            return result
        }

        private fun <U> fromRealmToNativeList(raw: RealmList<U>): List<U> {
            val result = ArrayList<U>(raw.size)
            result.addAll(raw)
            return result
        }
    }
}

