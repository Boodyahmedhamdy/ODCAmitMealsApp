package com.github.boodyahmedhamdy.domain.usecases

import com.github.boodyahmedhamdy.data.repos.MealsRepo
import com.github.boodyahmedhamdy.domain.models.toModel
import javax.inject.Inject

class GetAllMealsUseCase @Inject constructor (
    private val mealsRepo: MealsRepo
) {

    suspend operator fun invoke() =
        mealsRepo.getAllMeals().meals.map {
            it.toModel()
        }
}