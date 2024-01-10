package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class GetStateUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): GetStateUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.getState()
}

