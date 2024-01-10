package com.example.bulbyandex.domain

interface GetCurrentBrightnessUseCase {
    suspend operator fun invoke(): Result<Int?>
}