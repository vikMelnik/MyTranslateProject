package com.example.mytranslateproject.model.datasource

import com.example.mytranslateproject.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImpl : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented") // To change body of created functions use File
                                      // | Settings | File Templates.
    }
}