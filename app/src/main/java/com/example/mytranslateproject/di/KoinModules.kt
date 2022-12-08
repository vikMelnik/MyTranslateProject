package com.example.mytranslateproject.di

import androidx.room.Room
import com.example.model.data.dto.SearchResultDto
import com.example.mytranslateproject.model.datasource.RetrofitImplementation
import com.example.mytranslateproject.model.datasource.RoomDataBaseImplementation
import com.example.mytranslateproject.model.repository.Repository
import com.example.mytranslateproject.model.repository.RepositoryImpl
import com.example.mytranslateproject.model.repository.RepositoryImplementationLocal
import com.example.mytranslateproject.model.repository.RepositoryLocal
import com.example.mytranslateproject.room.HistoryDataBase
import com.example.mytranslateproject.view.history.HistoryInteractor
import com.example.mytranslateproject.view.history.HistoryViewModel
import com.example.mytranslateproject.view.main.MainActivity
import com.example.mytranslateproject.view.main.MainInteractor
import com.example.mytranslateproject.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java,
        "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> {
        RepositoryImpl(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

//
//val mainScreen = module {
//    scope(named<MainActivity>()) {
//        viewModel { MainViewModel(get()) }
//        scoped { MainInteractor(get(), get()) }
//    }
//}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}


//val historyScreen = module {
//    scope(named<HistoryActivity>()) {
//        scoped { HistoryInteractor(get(), get()) }
//        viewModel { HistoryViewModel(get()) }
//    }
//}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
