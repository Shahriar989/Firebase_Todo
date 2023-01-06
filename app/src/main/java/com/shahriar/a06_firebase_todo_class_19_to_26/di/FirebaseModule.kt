package com.shahriar.a06_firebase_todo_class_19_to_26.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

    @Provides
    @Singleton
    fun providesFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}