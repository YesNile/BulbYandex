package com.example.bulbyandex.domain

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}