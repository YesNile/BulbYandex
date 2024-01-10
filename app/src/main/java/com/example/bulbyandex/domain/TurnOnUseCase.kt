package com.example.bulbyandex.domain

interface TurnOnUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

