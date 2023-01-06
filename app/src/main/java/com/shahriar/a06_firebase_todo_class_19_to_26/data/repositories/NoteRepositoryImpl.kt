package com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.Constants

class NoteRepositoryImpl: NoteRepository {
    override fun add(note: Note) {

        val document = FirebaseFirestore.getInstance().collection(Constants.NOTE).document("note").set(note).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }
}