package com.shahriar.a06_firebase_todo_class_19_to_26.di

import com.google.firebase.firestore.FirebaseFirestore
import com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories.NoteRepository
import com.shahriar.a06_firebase_todo_class_19_to_26.data.repositories.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideNoteRepo(database: FirebaseFirestore): NoteRepository {
        // val  repo:NoteRepository= NoteRepositoryImpl(database)
        return NoteRepositoryImpl(database)
    }
}