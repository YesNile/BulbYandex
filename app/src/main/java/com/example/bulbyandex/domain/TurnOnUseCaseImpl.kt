package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class TurnOnUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): TurnOnUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOn()
}

