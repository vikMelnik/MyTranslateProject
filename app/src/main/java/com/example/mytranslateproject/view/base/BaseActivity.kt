package com.example.mytranslateproject.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.presenter.Presenter
import com.example.mytranslateproject.viewmodel.BaseViewModel

abstract class BaseActivity<T: AppState>: AppCompatActivity() {
    // В каждой Активити будет своя ViewModel, которая наследуется от BaseViewModel
    abstract val model: BaseViewModel<T>

    // Каждая Активити будет отображать какие-то данные в соответствующем состоянии
    abstract fun renderData(appState: T)
}

