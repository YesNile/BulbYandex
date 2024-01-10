package com.example.bulbyandex.di

import android.content.Context
import com.example.bulbyandex.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }