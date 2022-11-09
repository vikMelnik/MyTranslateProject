package com.example.mytranslateproject.view.main

import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.presenter.Interactor
import io.reactivex.Observable

class MainInteractor(
// Снабжаем интерактор репозиторием для получения локальных или внешних
// данных
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {
    // Интерактор лишь запрашивает у репозитория данные, детали имплементации
    // интерактору неизвестны
    override fun getData(word: String, fromRemoteSource: Boolean):
            Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
