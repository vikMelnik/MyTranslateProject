package com.example.mytranslateproject.model.repository

import com.example.model.data.AppState
import com.example.model.data.dto.SearchResultDto
import com.example.mytranslateproject.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResultDto>>) :
    RepositoryLocal<List<SearchResultDto>> {
    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
