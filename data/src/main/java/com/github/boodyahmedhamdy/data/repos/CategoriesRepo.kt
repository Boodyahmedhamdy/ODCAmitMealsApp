package com.github.boodyahmedhamdy.data.repos

import com.github.boodyahmedhamdy.data.remote.services.MealsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoriesRepo @Inject constructor (
    private val apiService: MealsApiService
) {

    suspend fun getAllCategories() = withContext(Dispatchers.IO) {
        return@withContext apiService.getAllCategories()
    }


}