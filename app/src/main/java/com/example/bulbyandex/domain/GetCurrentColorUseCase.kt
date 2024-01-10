package com.example.bulbyandex.domain

import com.example.bulbyandex.data.DataColor

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): Result<DataColor?>
}