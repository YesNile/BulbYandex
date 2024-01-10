package com.example.bulbyandex.di

import dagger.Binds
import dagger.Module

import com.example.bulbyandex.data.repository.StatusRepository
import com.example.bulbyandex.data.repository.StatusRepositoryImpl

import com.example.bulbyandex.domain.GetColorsUseCase
import com.example.bulbyandex.domain.GetColorsUseCaseImpl

import com.example.bulbyandex.domain.GetCurrentBrightnessUseCase
import com.example.bulbyandex.domain.GetCurrentBrightnessUseCaseImpl

import com.example.bulbyandex.domain.GetCurrentColorUseCase
import com.example.bulbyandex.domain.GetCurrentColorUseCaseImpl

import com.example.bulbyandex.domain.GetStateUseCase
import com.example.bulbyandex.domain.GetStateUseCaseImpl

import com.example.bulbyandex.domain.SetBrightnessUseCase
import com.example.bulbyandex.domain.SetBrightnessUseCaseImpl

import com.example.bulbyandex.domain.SetColorUseCase
import com.example.bulbyandex.domain.SetColorUseCaseImpl

import com.example.bulbyandex.domain.TurnOffUseCase
import com.example.bulbyandex.domain.TurnOffUseCaseImpl

import com.example.bulbyandex.domain.TurnOnUseCase
import com.example.bulbyandex.domain.TurnOnUseCaseImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: StatusRepositoryImpl): StatusRepository

    @Binds
    fun bindGetColorsUseCase(useCase: GetColorsUseCaseImpl): GetColorsUseCase

    @Binds
    fun bindTurnOnUseCase(useCase: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindTurnOffUseCase(useCase: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindGetStateUseCase(useCase: GetStateUseCaseImpl): GetStateUseCase

    @Binds
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    fun bindSetBrightnessUseCase(useCase: SetBrightnessUseCaseImpl): SetBrightnessUseCase

    @Binds
    fun bindGetCurrentBrightnessUseCase(useCase: GetCurrentBrightnessUseCaseImpl): GetCurrentBrightnessUseCase
}