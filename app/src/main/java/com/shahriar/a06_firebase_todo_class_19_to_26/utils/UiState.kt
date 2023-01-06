package com.shahriar.a06_firebase_todo_class_19_to_26.utils

sealed class UiState<out T>{

    object Loading: UiState<Nothing>()

    data class Success<out T>(val data: T): UiState<T>()

    data class Failure(val error: String?): UiState<Nothing>()
}
