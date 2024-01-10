package com.example.bulbyandex.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bulbyandex.presenter.StatusViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelInd): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(StatusViewModel::class)
    abstract fun bindSampleViewModel(viewModel: StatusViewModel): ViewModel

}