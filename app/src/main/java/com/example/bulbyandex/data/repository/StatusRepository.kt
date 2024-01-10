package com.example.bulbyandex.data.repository

import com.example.bulbyandex.data.DataColor

interface StatusRepository {
    suspend fun turnOn(): Result<Boolean?>
    suspend fun turnOff(): Result<Boolean?>
    suspend fun getState(): Result<Boolean?>
    suspend fun getColors(): Result<List<String>?>
    suspend fun getCurrentColor(): Result<DataColor?>
    suspend fun setColor(color: String): Result<Boolean?>
    suspend fun setBrightness(level: Int): Result<Boolean?>
    suspend fun getCurrentBrightness(): Result<Int?>

}
