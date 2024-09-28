package com.github.boodyahmedhamdy.domain.usecases

import com.github.boodyahmedhamdy.data.remote.services.MealsApiService
import com.github.boodyahmedhamdy.data.repos.MealsRepo
import com.github.boodyahmedhamdy.domain.models.toModel
import javax.inject.Inject

class GetMealByIdUseCase @Inject constructor (
    private val mealsRepo: MealsRepo
) {
    suspend operator fun invoke(id: Int) = mealsRepo.getMealById(id).meals.map {
        it.toModel()
    }
}