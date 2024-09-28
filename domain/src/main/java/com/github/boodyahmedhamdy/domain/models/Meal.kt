package com.github.boodyahmedhamdy.domain.models

import com.github.boodyahmedhamdy.data.remote.dtos.MealDTO

data class Meal(
    val id: String = "",
    val title: String = "",
    val category: String = "",
    val area: String = "",
    val instructions: String = "",
    val imageUrl: String = "",
    val tags: String = "",
    val youtubeUrl: String = "",
    val ingredients: List<String> = emptyList(),
    val measures: List<String> = emptyList(),
)

fun MealDTO.toModel(): Meal {
    return Meal(
        id = idMeal,
        title = strMeal,
        category = strCategory,
        area = strArea,
        instructions = strInstructions,
        imageUrl = strMealThumb,
        tags = strTags ?: "No tags",
        youtubeUrl = strYoutube,
        ingredients = listOf(
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strIngredient6,
            strIngredient7,
            strIngredient8,
            strIngredient9,
            strIngredient10,
            strIngredient11,
            strIngredient12,
            strIngredient13,
            strIngredient14,
            strIngredient15,
            strIngredient16,
            strIngredient17,
            strIngredient18,
            strIngredient19,
            strIngredient20,
        ),
        measures = listOf(
            strMeasure1,
            strMeasure2,
            strMeasure3,
            strMeasure4,
            strMeasure5,
            strMeasure6,
            strMeasure7,
            strMeasure8,
            strMeasure9,
            strMeasure10,
            strMeasure11,
            strMeasure12,
            strMeasure13,
            strMeasure14,
            strMeasure15,
            strMeasure16,
            strMeasure17,
            strMeasure18,
            strMeasure19,
            strMeasure20,
        )
    )
}