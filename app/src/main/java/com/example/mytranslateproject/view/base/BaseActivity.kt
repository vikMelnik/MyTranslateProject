package com.example.mytranslateproject.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytranslateproject.model.data.AppState
import com.example.mytranslateproject.presenter.Presenter

abstract class BaseActivity<T: AppState>: AppCompatActivity(), View {
    // Храним ссылку на презентер
    protected lateinit var presenter: Presenter<T, View>
    protected abstract fun createPresenter(): Presenter<T, View>
    abstract override fun renderData(appState: AppState)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    // Когда View готова отображать данные, передаём ссылку на View в презентер
    override fun onStart() {
        super.onStart()
        presenter.attacheView(this)
    }

    // При пересоздании или уничтожении View удаляем ссылку, иначе в презентере
    // будет ссылка на несуществующую View
    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}