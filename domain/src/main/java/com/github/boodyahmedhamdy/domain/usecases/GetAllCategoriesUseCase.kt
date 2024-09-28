package com.github.boodyahmedhamdy.domain.usecases

import android.util.Log
import com.github.boodyahmedhamdy.data.repos.CategoriesRepo
import com.github.boodyahmedhamdy.domain.models.Category
import com.github.boodyahmedhamdy.domain.models.toModel
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor (
    private val categoriesRepo: CategoriesRepo
) {

    suspend operator fun invoke(): List<Category>  {
        return try {
            categoriesRepo.getAllCategories().categories.map {
                it.toModel()
            }
        } catch (e: Exception) {
            Log.e("GetAllCategoriesUseCase", e.printStackTrace().toString())
            emptyList()
        }
    }
}