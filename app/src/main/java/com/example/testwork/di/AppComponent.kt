package com.example.testwork.di

import android.app.Application
import com.example.testwork.App
import com.example.testwork.ui.dashboard.HistoryFragment
import com.example.testwork.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Singleton

@Component(modules = [DatabaseModule::class, ViewModelModule::class, DaoModule::class])
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: HistoryFragment)
    fun inject(app: App)
    fun inject(homeFragment: HomeFragment)

}