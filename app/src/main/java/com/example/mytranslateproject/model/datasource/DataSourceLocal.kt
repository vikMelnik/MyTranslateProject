package com.example.mytranslateproject.model.datasource

import com.example.mytranslateproject.model.data.DataModel
import io.reactivex.Observable

// Для локальных данных используется Room
class DataSourceLocal(private val remoteProvider: RoomDataBaseImpl =
                          RoomDataBaseImpl()) :
    DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvider.getData(word)
}
