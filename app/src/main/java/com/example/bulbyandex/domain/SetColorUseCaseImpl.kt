package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): SetColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean?> =
        repository.setColor(color)
}