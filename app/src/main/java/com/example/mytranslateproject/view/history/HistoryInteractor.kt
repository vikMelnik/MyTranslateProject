package com.example.mytranslateproject.view.history

import com.example.model.data.AppState
import com.example.model.data.DataModel
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.model.repository.RepositoryLocal
import com.example.mytranslateproject.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
