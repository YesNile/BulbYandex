package com.example.bulbyandex.domain

interface GetStateUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

