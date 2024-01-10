package com.example.bulbyandex.domain

import com.example.bulbyandex.data.DataColor
import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): GetCurrentColorUseCase {
    override suspend fun invoke(): Result<DataColor?> =
        repository.getCurrentColor()
}