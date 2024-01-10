package com.example.bulbyandex.data.repository

import com.example.bulbyandex.data.DataColor
import com.example.bulbyandex.data.api.ApiService
import okhttp3.RequestBody
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class StatusRepositoryImpl @Inject constructor(
    private val service: ApiService,
) : StatusRepository {

    override suspend fun getState(): Result<Boolean?> {
        kotlin.runCatching {
            service.getState()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun turnOn(): Result<Boolean?>{
        kotlin.runCatching {
            service.turnOn()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun turnOff(): Result<Boolean?>{
        kotlin.runCatching {
            service.turnOff()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setBrightness(level: Int): Result<Boolean?> {
        kotlin.runCatching {
            service.setBrightness(level)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentBrightness(): Result<Int?> {
        kotlin.runCatching {
            service.getCurrentBrightness()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getColors(): Result<List<String>?> {
        kotlin.runCatching {
            service.getColors()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentColor(): Result<DataColor?> {
        kotlin.runCatching {
            service.getCurrentColor()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

}