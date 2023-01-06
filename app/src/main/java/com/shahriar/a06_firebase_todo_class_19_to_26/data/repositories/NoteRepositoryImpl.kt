package com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.Constants

class NoteRepositoryImpl(database: FirebaseFirestore) : NoteRepository {
    override fun add(note: Note) {

        val document = FirebaseFirestore.getInstance().collection(Constants.NOTE).document("note").set(note).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }
    val allNotes = MutableLiveData<List<Note>>()

    override fun getAllTask() {
        TODO("Not yet implemented")
    }
}