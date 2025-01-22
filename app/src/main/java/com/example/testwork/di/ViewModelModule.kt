package com.example.testwork.di

import com.example.testwork.data.room.BinDao
import com.example.testwork.repository.Repository
import com.example.testwork.ui.dashboard.HistoryViewModelFactory
import com.example.testwork.ui.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideRepository(binDao: BinDao): Repository {
        return Repository(binDao)
    }
    @Provides
    fun provideHomeViewModelFactory(repository: Repository): HomeViewModelFactory {
        return HomeViewModelFactory(repository)
    }
    @Provides
    fun provideHistoryViewModelFactory(repository: Repository): HistoryViewModelFactory {
        return HistoryViewModelFactory(repository)
    }
}