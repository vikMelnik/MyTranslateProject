package com.example.mytranslateproject.model.datasource

import com.example.mytranslateproject.model.data.DataModel
import io.reactivex.Observable

// Для получения внешних данных мы будем использовать Retrofit
class DataSourceRemote(private val remoteProvider: RetrofitImpl =
                           RetrofitImpl()) :
    DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvider.getData(word)
}