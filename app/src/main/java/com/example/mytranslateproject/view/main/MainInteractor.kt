package com.example.mytranslateproject.view.main

import com.example.mytranslateproject.model.repository.Repository
import com.example.model.data.AppState
import com.example.model.data.dto.SearchResultDto
import com.example.mytranslateproject.model.repository.RepositoryLocal
import com.example.mytranslateproject.utils.mapSearchResultToResult
import com.example.mytranslateproject.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState =
                AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState =
                AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
