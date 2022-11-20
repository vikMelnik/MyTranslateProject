package com.example.mytranslateproject.viewmodel

interface Interactor<T> {
    // Добавляем suspend
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}