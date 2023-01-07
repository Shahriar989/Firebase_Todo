package com.shahriar.a06_firebase_todo_class_19_to_26.utils

sealed class UiState<T>(val data: T?= null, val message: String?= null){

    class Loading<T>: UiState<T>()

    class Success<T>(data: T?=null, message: String?): UiState<T>(data, message)

    class Failure<T>(data: T?=null, message: String): UiState<T>(data, message)
}
