package com.example.mytranslateproject.model.datasource

import com.example.mytranslateproject.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    // Добавляем suspend
    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") // To change body of created functions use File
                                      // | Settings | File Templates.
    }
}
