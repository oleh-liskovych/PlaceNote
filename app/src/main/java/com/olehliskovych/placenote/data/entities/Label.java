package com.olehliskovych.placenote.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Label extends RealmObject implements Parcelable {

    public static final Parcelable.Creator<Label> CREATOR = new Parcelable.Creator<Label>() {
        public Label createFromParcel(Parcel in) {
            return new Label(in);
        }

        public Label[] newArray(int size) {
            return new Label[size];
        }
    };

    @PrimaryKey
    @NonNull
    private String name;

    public Label(@NonNull String name) {
        this.name = name;
    }

    public Label() {
        name = "";
    }

    public Label(Parcel in) {
        this.name = in.readString();
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
    }
}
