package com.example.mytranslateproject.presenter

import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.view.base.View

// На уровень выше находится презентер, который уже ничего не знает ни о контексте, ни о фреймворке
interface Presenter<T : AppState, V : View> {
    fun attacheView(view: V)
    fun detachView(view: V)

    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)
}