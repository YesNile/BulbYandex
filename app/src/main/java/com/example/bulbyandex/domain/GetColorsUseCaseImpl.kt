package com.example.bulbyandex.domain

import com.example.bulbyandex.data.repository.StatusRepository
import javax.inject.Inject

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: StatusRepository,
): GetColorsUseCase {
    override suspend fun invoke(): Result<List<String>?> =
        repository.getColors()

}

