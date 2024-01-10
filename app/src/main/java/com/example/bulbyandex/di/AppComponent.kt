package com.example.bulbyandex.di

import com.example.bulbyandex.presenter.StatusFragment
import dagger.Component

@Component(
    modules = [ AppModule::class ]
)
interface AppComponent {
    fun inject(fragment: StatusFragment)
}