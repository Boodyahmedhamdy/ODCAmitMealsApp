package com.github.boodyahmedhamdy.odcamitmealsapp.ui.states

import com.github.boodyahmedhamdy.domain.models.Meal

data class MealUiState(
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

fun Meal.toUiState(): MealUiState {
    return MealUiState(
        id = id,
        title = title,
        category = category,
        area = area,
        instructions = instructions,
        imageUrl = imageUrl,
        tags = tags,
        youtubeUrl = youtubeUrl,
        ingredients = ingredients,
        measures = measures
    )
}
