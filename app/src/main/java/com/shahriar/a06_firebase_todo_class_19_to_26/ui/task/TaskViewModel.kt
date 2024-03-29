package com.shahriar.a06_firebase_todo_class_19_to_26.ui.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahriar.a06_firebase_todo_class_19_to_26.data.model.Note
import com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories.NoteRepositoryImpl
import com.shahriar.a06_firebase_todo_class_19_to_26.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(var repositoryImpl: NoteRepositoryImpl) : ViewModel() {

    fun addNote(note: Note) = repositoryImpl.add(note)

    val createNoteResponse = repositoryImpl.responseCreateNote

    fun getAllTaskData() = repositoryImpl.getAllTask()

    val allTask = repositoryImpl.allTask
}