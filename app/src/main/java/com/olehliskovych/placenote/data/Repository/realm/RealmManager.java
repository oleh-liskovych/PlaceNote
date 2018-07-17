package com.olehliskovych.placenote.data.Repository.realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.olehliskovych.placenote.data.Repository.Repository;
import com.olehliskovych.placenote.data.entities.Label;
import com.olehliskovych.placenote.data.entities.Note;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

public class RealmManager implements Repository{

    @Inject
    Realm realm;

    @Override
    public List<Note> getNotesForLabel(@Nullable Label label) {
        return null;
    }

    @Override
    public List<Label> getAllLabels() {
        return null;
    }

    @Override
    public void updateNote(@NonNull Note note) {

    }
}
