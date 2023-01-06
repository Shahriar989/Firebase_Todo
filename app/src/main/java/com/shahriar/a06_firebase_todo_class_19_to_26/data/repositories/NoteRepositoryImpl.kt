package com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.Constants
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val database: FirebaseFirestore
) : NoteRepository {

    override fun add(note: Note) {

        val document = database.collection(Constants.NOTE).document()

        note.id = document.id

        document.set(note).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }

    val allNotes = MutableLiveData<List<Note>>()

    override fun getAllTask() {

        val notes = arrayListOf<Note>()

        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener { snapshot ->

                for (document in snapshot){
                    val note = document.toObject(Note::class.java)
                    notes.add(note)
                }
                allNotes.value = notes
            }.addOnFailureListener {

            }
    }
}