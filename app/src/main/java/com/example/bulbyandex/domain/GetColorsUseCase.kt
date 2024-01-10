package com.example.bulbyandex.domain

interface GetColorsUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

