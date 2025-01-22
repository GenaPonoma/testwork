package com.example.testwork

import android.app.Application
import com.example.testwork.di.AppComponent
import com.example.testwork.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}