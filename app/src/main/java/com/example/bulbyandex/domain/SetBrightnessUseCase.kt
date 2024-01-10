package com.example.bulbyandex.domain

interface SetBrightnessUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean?>
}