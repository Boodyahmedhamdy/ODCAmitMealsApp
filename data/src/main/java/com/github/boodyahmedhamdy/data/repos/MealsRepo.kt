package com.github.boodyahmedhamdy.data.repos

import com.github.boodyahmedhamdy.data.remote.services.MealsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealsRepo @Inject constructor(
    private val apiService: MealsApiService
) {

    suspend fun getAllMeals() = withContext(Dispatchers.IO) {
        return@withContext apiService.getAllMeals()
    }


    suspend fun getMealById(id: Int) = withContext(Dispatchers.IO) {
        return@withContext apiService.getMealById(id)
    }
}