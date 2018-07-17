package com.olehliskovych.placenote.data.entities;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject implements Parcelable{

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @PrimaryKey
    private String id;
    private String title;
    private String message;

    private int radius;
    private double latitude;
    private double longitude;

    private RealmList<Label> labels;

    private Date updateDate;

    public Note(){}

    public Note(Location location) {
        id = UUID.randomUUID().toString();
        title = "";
        message = "";
        radius = 100;
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        labels = new RealmList<>();
        updateDate = new Date();
    }

    public Note(String id, String title, String message, int radius, Location location, List<Label> labels, Date updateDate) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.radius = radius;
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.labels = fromNativeToRealmList(labels);
        this.updateDate = updateDate;
    }

    public Note(Parcel in) {
        this.id = in.readString();
        this.id = in.readString();
        this.message = in.readString();
        this.radius = in.readInt();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.labels = fromNativeToRealmList(in.createTypedArrayList(Label.CREATOR));
        this.updateDate = new Date(in.readLong());
    }

    private static <U> RealmList<U> fromNativeToRealmList(List<U> raw) {
        RealmList<U> result = new RealmList<>();
        result.addAll(raw);
        return result;
    }

    private static <U> List<U> fromRealmToNativeList(RealmList<U> raw) {
        List<U> result = new ArrayList<>(raw.size());
        result.addAll(raw);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.message);
        dest.writeInt(this.radius);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeTypedList(fromRealmToNativeList(this.labels));
        dest.writeLong(updateDate.getTime());
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", radius=" + radius +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", labels=" + labels +
                ", updateDate=" + updateDate +
                '}';
    }
}
