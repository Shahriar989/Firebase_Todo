package com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories

import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.UiState

interface NoteRepository {

    fun add(note: Note)

    fun getAllTask(result: (UiState<List<Note>>)-> Unit)

    fun delete(note: Note)
}