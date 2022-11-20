package com.example.mytranslateproject.model.data.api

import com.example.mytranslateproject.model.data.DataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
// Метод теперь возвращает Deferred
    fun searchAsync(@Query("search") wordToSearch: String):
            Deferred<List<DataModel>>
}
