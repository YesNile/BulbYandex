package com.example.bulbyandex.domain

interface TurnOffUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}