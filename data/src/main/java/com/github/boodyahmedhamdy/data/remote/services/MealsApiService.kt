package com.github.boodyahmedhamdy.data.remote.services

import com.github.boodyahmedhamdy.data.remote.dtos.CategoriesResponse
import com.github.boodyahmedhamdy.data.remote.dtos.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoriesResponse

    @GET("search.php?s=")
    suspend fun getAllMeals(
    ): MealsResponse

    @GET("lookup.php")
    suspend fun getMealById(
        @Query("i") id: Int
    ): MealsResponse
}