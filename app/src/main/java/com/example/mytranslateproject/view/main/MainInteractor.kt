package com.example.mytranslateproject.view.main

import com.example.model.data.DataModel
import com.example.mytranslateproject.model.repository.Repository
import com.example.model.data.AppState
import com.example.mytranslateproject.model.repository.RepositoryLocal
import com.example.mytranslateproject.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
