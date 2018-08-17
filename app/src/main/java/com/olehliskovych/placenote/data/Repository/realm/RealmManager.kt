package com.olehliskovych.placenote.data.Repository.realm

import com.olehliskovych.placenote.data.Repository.Repository
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.data.entities.Note
import io.reactivex.Completable
import io.reactivex.Flowable
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

class RealmManager @Inject constructor(var realm: Realm) : Repository {


    override val allLabels: Flowable<List<Label>>
        get() {
            val results = realm.where(Label::class.java).findAll()
            return results.asFlowable().map { r -> realm.copyFromRealm(r) }
        }

    override fun getNotesForLabel(label: Label?): Flowable<List<Note>> {
        val results: RealmResults<Note>
        if (label == null) {
            results = realm.where(Note::class.java).findAll()
        } else {
            results = realm.where(Note::class.java)
                    .contains("labels", label.name)
                    .findAll()
        }

        return results.asFlowable().map { r -> realm.copyFromRealm(r) }
    }

    override fun updateNote(note: Note): Completable {
        return Completable.create { source ->
            realm.executeTransactionAsync({ realm ->
                val realmNote = realm.copyToRealm(note)
                realm.insertOrUpdate(realmNote)
            }, { source.onComplete() }, { source.onError(it) })
        }
    }

    override fun updateLabel(label: Label): Completable {
        return Completable.create { source ->
            realm.executeTransactionAsync({ realm ->
                val realmLabel = realm.copyToRealm(label)
                realm.insertOrUpdate(realmLabel)
            }, { source.onComplete() }, { source.onError(it) })
        }
    }

    override fun deleteNote(note: Note): Completable {
        return Completable.create { source ->
            realm.executeTransactionAsync({ realm ->
                val realmNote = realm.copyToRealm(note)
                realmNote.deleteFromRealm()
            }, { Completable.complete() }, { Completable.error(it) })
        }
    }

    override fun deleteLabel(label: Label): Completable {
        return Completable.create { source ->
            realm.executeTransactionAsync({ realm ->
                val realmLabel = realm.copyToRealm(label)
                realmLabel.deleteFromRealm()
            }, { Completable.complete() }, { Completable.error(it) })
        }
    }
}
