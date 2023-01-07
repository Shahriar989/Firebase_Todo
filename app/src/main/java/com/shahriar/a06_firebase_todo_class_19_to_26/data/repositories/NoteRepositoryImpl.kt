package com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.Constants
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.UiState
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val database: FirebaseFirestore) :
    NoteRepository {

    private var _responseCreateNote = MutableLiveData<UiState<String>>()

    val responseCreateNote : LiveData<UiState<String>>

    get() = _responseCreateNote

    override fun add(note: Note) {

        _responseCreateNote.postValue(UiState.Loading())

        val document = database.collection(Constants.NOTE).document()

        note.id = document.id

        document.set(note).addOnSuccessListener {

            _responseCreateNote.postValue(UiState.Success(message = Constants.NOTE_CREATED))

        }.addOnFailureListener {

            _responseCreateNote.postValue(UiState.Failure(message = it.localizedMessage!!))

        }
    }

    private var _allTask = MutableLiveData<UiState<List<Note>>>()
    val allTask: LiveData<UiState<List<Note>>>
        get() = _allTask

    override fun getAllTask() {

        val notes = arrayListOf<Note>()

        _allTask.postValue(UiState.Loading())

        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener { snapshot ->

                for (document in snapshot) {
                    val note = document.toObject(Note::class.java)
                    notes.add(note)
                }

                _allTask.postValue(UiState.Success(notes, null))

                //allNotes.value = notes

            }.addOnFailureListener {

                _allTask.postValue(it.localizedMessage?.let { msg ->

                    UiState.Failure(message = msg)
                })
            }
    }

    override fun delete(note: Note) {
        TODO("Not yet implemented")
    }
}