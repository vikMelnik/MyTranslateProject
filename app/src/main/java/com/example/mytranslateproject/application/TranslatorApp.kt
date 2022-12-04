package com.example.mytranslateproject.application

import android.app.Application
import com.example.mytranslateproject.di.application
import com.example.mytranslateproject.di.historyScreen
import com.example.mytranslateproject.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}

