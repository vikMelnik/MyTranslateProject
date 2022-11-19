package com.example.mytranslateproject.view.main

import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {
    override fun getData(word: String, fromRemoteSource: Boolean):
            Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}
