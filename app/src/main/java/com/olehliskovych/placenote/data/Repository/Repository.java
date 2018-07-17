package com.olehliskovych.placenote.data.Repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.olehliskovych.placenote.data.entities.Label;
import com.olehliskovych.placenote.data.entities.Note;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface Repository {
    Flowable<List<Note>> getNotesForLabel(@Nullable Label label);
    Flowable<List<Label>> getAllLabels();
    Completable updateNote(@NonNull Note note);
    Completable updateLabel(@NonNull Label label);
    Completable deleteNote(@NonNull Note note);
    Completable deleteLabel(@NonNull Label label);
}
