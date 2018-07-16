package com.olehliskovych.placenote.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import com.olehliskovych.placenote.data.Converters;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "notes")
public class Note implements Parcelable{

//    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
//        public N
//    }

    @PrimaryKey
    private String id;
    private String title;
    private String message;

    private int radius;
    private Location location;

    @TypeConverters(Converters.class) // todo: move this row to AppDatabase class
    private List<Label> labels;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "update_date")
    private Date updateDate;

    @Ignore
    public Note(Location location) {
        id = UUID.randomUUID().toString();
        title = "";
        message = "";
        radius = 100;
        this.location = location;
        labels = new LinkedList<>();
        updateDate = new Date();
    }

    public Note(String id, String title, String message, int radius, Location location, List<Label> labels, Date updateDate) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.radius = radius;
        this.location = location;
        this.labels = labels;
        this.updateDate = updateDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
