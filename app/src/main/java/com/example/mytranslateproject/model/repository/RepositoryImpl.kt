package com.example.mytranslateproject.model.repository

import com.example.model.data.dto.SearchResultDto
import com.example.mytranslateproject.model.datasource.DataSource

class RepositoryImpl(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {
    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}

