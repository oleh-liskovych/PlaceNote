package com.olehliskovych.placenote.data.Repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.olehliskovych.placenote.data.entities.Label;
import com.olehliskovych.placenote.data.entities.Note;

import java.util.List;

public interface Repository {
    List<Note> getNotesForLabel(@Nullable Label label);
    List<Label> getAllLabels();
    void updateNote(@NonNull Note note);

}
