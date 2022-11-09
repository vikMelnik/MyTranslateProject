package com.example.mytranslateproject.view.main

import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.model.datasource.DataSourceLocal
import com.example.mytranslateproject.model.datasource.DataSourceRemote
import com.example.mytranslateproject.model.repository.RepositoryImpl
import com.example.mytranslateproject.presenter.Presenter
import com.example.mytranslateproject.rx.SchedulerProvider
import com.example.mytranslateproject.view.base.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainPresenterImpl<T : AppState, V : View>(
// Обратите внимание, что Интерактор мы создаём сразу в конструкторе
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImpl(DataSourceRemote()),
        RepositoryImpl(DataSourceLocal())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),

    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {
    // Ссылка на View, никакого контекста
    private var currentView: V? = null

// View скоро будет уничтожена: прерываем все загрузки и обнуляем ссылку,
// чтобы предотвратить утечки памяти и NPE
    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

// Стандартный код RxJava
    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                // Как только начинается загрузка, передаём во View модель данных для
                // отображения экрана загрузки
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                // Если загрузка окончилась успешно, передаем модель с данными
                // для отображения
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                // Если произошла ошибка, передаем модель с ошибкой
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
// Как только появилась View, сохраняем ссылку на неё для дальнейшей работы
    override fun attacheView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }
}

