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

    override fun add(note: Note) {

        val document = database.collection(Constants.NOTE).document()

        note.id = document.id

        document.set(note).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }

    private var _allTask = MutableLiveData<UiState<List<Note>>>()
    val allTask : LiveData<UiState<List<Note>>>
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

                _allTask.postValue(UiState.Success(notes))

                //allNotes.value = notes

            }.addOnFailureListener {

                _allTask.postValue(it.localizedMessage?.let { msg ->

                    UiState.Failure(message = msg)
                })


//                Log.i("TAG", "getAllTask: ${it.localizedMessage}")
//
//                result.invoke(
//                    UiState.Failure("${it.localizedMessage}")
//                )

            }
    }

    override fun delete(note: Note) {
        TODO("Not yet implemented")
    }
}