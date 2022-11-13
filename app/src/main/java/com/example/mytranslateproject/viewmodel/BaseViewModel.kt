package com.example.mytranslateproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    protected var liveData: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable =
        CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {
    open fun getData(word: String, isOnline: Boolean): LiveData<T> =
        liveData

    // Метод класса ViewModel, который вызывается перед уничтожением Activity
    override fun onCleared() {
        compositeDisposable.clear()
    }
}