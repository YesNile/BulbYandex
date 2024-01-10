package com.example.bulbyandex

import android.app.Application
import com.example.bulbyandex.di.AppComponent
import com.example.bulbyandex.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }

}