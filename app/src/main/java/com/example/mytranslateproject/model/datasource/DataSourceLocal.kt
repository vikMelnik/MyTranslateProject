package com.example.mytranslateproject.model.datasource

import com.example.mytranslateproject.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
