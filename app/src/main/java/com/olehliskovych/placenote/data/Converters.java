package com.olehliskovych.placenote.data;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.olehliskovych.placenote.data.entities.Label;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class Converters {

    @TypeConverter
    public String fromLabelList(List<Label> labels) {
        if (labels == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Label>>() {
        }.getType();
        return gson.toJson(labels, type);
    }

    @TypeConverter
    public List<Label> toLabelsList(String labelsString) {
        if (labelsString == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Label>>() {
        }.getType();
        return gson.fromJson(labelsString, type);
    }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
