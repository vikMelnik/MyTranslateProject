package com.example.mytranslateproject.model.repository

import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.datasource.DataSource

class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
