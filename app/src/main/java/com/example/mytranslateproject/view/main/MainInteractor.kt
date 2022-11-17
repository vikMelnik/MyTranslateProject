package com.example.mytranslateproject.view.main

import com.example.mytranslateproject.di.NAME_LOCAL
import com.example.mytranslateproject.di.NAME_REMOTE
import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}
