package com.example.mytranslateproject.model.repository

import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    // Репозиторий возвращает данные, используя dataSource (локальный или
    // внешний)
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
