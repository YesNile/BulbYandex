package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class SetBrightnessUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): SetBrightnessUseCase {
    override suspend fun invoke(level: Int): Result<Boolean?> =
        repository.setBrightness(level)
}