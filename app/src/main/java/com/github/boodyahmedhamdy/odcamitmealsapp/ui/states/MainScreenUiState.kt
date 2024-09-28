package com.github.boodyahmedhamdy.odcamitmealsapp.ui.states

data class MainScreenUiState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val meals: List<MealUiState> = emptyList()
)
