package com.example.mytranslateproject.di

import com.example.mytranslateproject.model.data.DataModel
import com.example.mytranslateproject.model.datasource.RetrofitImplementation
import com.example.mytranslateproject.model.datasource.RoomDataBaseImplementation
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.model.repository.RepositoryImpl
import com.example.mytranslateproject.view.main.MainInteractor
import com.example.mytranslateproject.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

// Создадим две переменные: в одной находятся зависимости,
// используемые во всём приложении, во второй - зависимости конкретного экрана
val application = module {
// Функция single сообщает Koin, что эта зависимость должна храниться
// в виде синглтона (в Dagger есть похожая аннотация)
// Аннотация named выполняет аналогичную Dagger функцию
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImplementation())
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImpl(RoomDataBaseImplementation())
    }
}

// Функция factory сообщает Koin, что эту зависимость нужно создавать каждый
// раз заново, что как раз подходит для Activity и её компонентов.
val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
