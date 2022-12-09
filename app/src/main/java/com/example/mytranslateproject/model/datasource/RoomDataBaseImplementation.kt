package com.example.mytranslateproject.model.datasource

import com.example.model.data.AppState
import com.example.model.data.dto.SearchResultDto
import com.example.mytranslateproject.room.HistoryDao
import com.example.mytranslateproject.utils.convertDataModelSuccessToEntity
import com.example.mytranslateproject.utils.mapHistoryEntityToSearchResult


// Теперь наш локальный репозиторий работает. Передаём в конструктор
// HistoryDao (вспоминаем в модуле Koin RoomDataBaseImplementation(get())).
class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}

