package com.olehliskovych.placenote.data.Repository.realm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.olehliskovych.placenote.data.Repository.Repository;
import com.olehliskovych.placenote.data.entities.Label;
import com.olehliskovych.placenote.data.entities.Note;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmManager implements Repository {

    @Inject
    Realm realm;

    @Override
    public Flowable<List<Note>> getNotesForLabel(@Nullable Label label) {
        RealmResults<Note> results;
        if (label == null) {
            results = realm.where(Note.class).findAll();
        } else {
            results = realm.where(Note.class)
                    .contains("labels", label.getName())
                    .findAll();
        }

        return results.asFlowable().map(r -> {
            return realm.copyFromRealm(r);
        });
    }

    @Override
    public Flowable<List<Label>> getAllLabels() {
        RealmResults<Label> results = realm.where(Label.class).findAll();
        return results.asFlowable().map(r -> {
            return realm.copyFromRealm(r);
        });
    }

    @Override
    public Completable updateNote(@NonNull Note note) {
        return Completable.create(source -> realm.executeTransactionAsync(realm -> {
            Note realmNote = realm.copyToRealm(note);
            realm.insertOrUpdate(realmNote);
        }, source::onComplete, source::onError));
    }

    @Override
    public Completable updateLabel(@NonNull Label label) {
        return Completable.create(source -> realm.executeTransactionAsync(realm -> {
            Label realmLabel = realm.copyToRealm(label);
            realm.insertOrUpdate(realmLabel);
        }, source::onComplete, source::onError));
    }

    @Override
    public Completable deleteNote(@NonNull Note note) {
        return Completable.create(source ->
                realm.executeTransactionAsync(realm -> {
                    Note realmNote = realm.copyToRealm(note);
                    realmNote.deleteFromRealm();
                }, Completable::complete, Completable::error));
    }

    @Override
    public Completable deleteLabel(@NonNull Label label) {
        return Completable.create(source ->
                realm.executeTransactionAsync(realm -> {
                    Label realmLabel = realm.copyToRealm(label);
                    realmLabel.deleteFromRealm();
                }, Completable::complete, Completable::error));
    }
}
