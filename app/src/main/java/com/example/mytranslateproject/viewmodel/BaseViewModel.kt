package com.example.mytranslateproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytranslateproject.rx.SchedulerProvider
import com.example.mytranslateproject.model.data.AppState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    protected open val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected open val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected open val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    abstract fun getData(word: String, isOnline: Boolean)

    override fun onCleared() {
        compositeDisposable.clear()
    }
}
