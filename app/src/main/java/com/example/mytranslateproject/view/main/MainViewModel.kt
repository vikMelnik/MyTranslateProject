package com.example.mytranslateproject.view.main

import androidx.lifecycle.LiveData
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.utils.parseSearchResults
import com.example.mytranslateproject.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {
    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }
    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
// Запускаем корутину для асинхронного доступа к серверу с помощью launch
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }
    // Добавляем suspend
// withContext(Dispatchers.IO) указывает, что доступ в сеть должен
// осуществляться через диспетчер IO (который предназначен именно для таких
// операций), хотя это и не обязательно указывать явно, потому что Retrofit
// и так делает это благодаря CoroutineCallAdapterFactory(). Это же
// касается и Room
    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(parseSearchResults(interactor.getData(word,
                isOnline)))
        }
    // Обрабатываем ошибки
    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }
    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
