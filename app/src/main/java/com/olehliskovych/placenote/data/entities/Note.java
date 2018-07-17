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

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "notes")
public class Note implements Parcelable{

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
    private Location location;

    @TypeConverters(Converters.class) // todo: move this row to AppDatabase class
    private ArrayList<Label> labels;

    @TypeConverters(Converters.class)  // todo: move this row to AppDatabase class
    @ColumnInfo(name = "update_date")
    private Date updateDate;

    @Ignore
    public Note(Location location) {
        id = UUID.randomUUID().toString();
        title = "";
        message = "";
        radius = 100;
        this.location = location;
        labels = new ArrayList<>();
        updateDate = new Date();
    }

    public Note(String id, String title, String message, int radius, Location location, ArrayList<Label> labels, Date updateDate) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.radius = radius;
        this.location = location;
        this.labels = labels;
        this.updateDate = updateDate;
    }

    @Ignore
    public Note(Parcel in) {
        this.id = in.readString();
        this.id = in.readString();
        this.message = in.readString();
        this.radius = in.readInt();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.labels = in.createTypedArrayList(Label.CREATOR);
        this.updateDate = new Date(in.readLong());
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
        dest.writeParcelable(this.location, i);
        dest.writeTypedList(this.labels);
        dest.writeLong(updateDate.getTime());
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", radius=" + radius +
                ", location=" + location +
                ", labels=" + labels +
                ", updateDate=" + updateDate +
                '}';
    }
}
