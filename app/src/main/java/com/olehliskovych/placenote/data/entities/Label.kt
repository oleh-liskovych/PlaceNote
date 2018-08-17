package com.olehliskovych.placenote.data.entities

import android.os.Parcel
import android.os.Parcelable

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Label(@PrimaryKey open var name: String = ""): RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
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
