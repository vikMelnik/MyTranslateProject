package com.example.mytranslateproject.model.datasource

// Источник данных для репозитория (Интернет, БД и т. п.)
interface DataSource<T> {
    // Добавляем suspend
    suspend fun getData(word: String): T
}
