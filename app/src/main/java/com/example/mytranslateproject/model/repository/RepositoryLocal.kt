package com.example.mytranslateproject.model.repository

import com.example.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}
