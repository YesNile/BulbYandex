package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class GetCurrentBrightnessUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): GetCurrentBrightnessUseCase {
    override suspend fun invoke(): Result<Int?> =
        repository.getCurrentBrightness()
}