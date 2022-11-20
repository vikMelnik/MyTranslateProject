package com.example.mytranslateproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytranslateproject.model.data.AppState
import kotlinx.coroutines.*

abstract class BaseViewModel<T : AppState>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {
    // Объявляем свой собственный скоуп
// В качестве аргумента передается CoroutineContext, который мы составляем
// через "+" из трех частей:
// - Dispatchers.Main говорит, что результат работы предназначен для
// основного потока;
// - SupervisorJob() позволяет всем дочерним корутинам выполняться
// независимо, то есть, если какая-то корутина упадёт с ошибкой, остальные
// будут выполнены нормально;
// - CoroutineExceptionHandler позволяет перехватывать и отрабатывать
// ошибки и краши
    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    // Завершаем все незавершённые корутины, потому что пользователь закрыл экран
    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    abstract fun getData(word: String, isOnline: Boolean)

    // обрабатываем ошибки в конкретной имплементации базовой ВьюМодели
    abstract fun handleError(error: Throwable)
}
