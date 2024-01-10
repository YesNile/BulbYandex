package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class TurnOffUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): TurnOffUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOff()
}

