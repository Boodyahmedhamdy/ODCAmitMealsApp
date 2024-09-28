package com.github.boodyahmedhamdy.odcamitmealsapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.boodyahmedhamdy.domain.models.Category
import com.github.boodyahmedhamdy.domain.usecases.GetAllCategoriesUseCase
import com.github.boodyahmedhamdy.domain.usecases.GetAllMealsUseCase
import com.github.boodyahmedhamdy.domain.usecases.GetMealByIdUseCase
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MainScreenUiState
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MealUiState
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor (
    private val getAllMealsUseCase: GetAllMealsUseCase,
    private val getMealByIdUseCase: GetMealByIdUseCase
): ViewModel() {

    private val _mainScreenUiState: MutableStateFlow<MainScreenUiState> = MutableStateFlow(
        MainScreenUiState()
    )
    val mainScreenUiState:StateFlow<MainScreenUiState> = _mainScreenUiState.asStateFlow()

    private val _selectedMeal: MutableStateFlow<MealUiState> = MutableStateFlow(MealUiState())
    val selectedMeal = _selectedMeal.asStateFlow()


    init {
        loadMealsFromRemote()
    }

    private fun loadMealsFromRemote() {
        viewModelScope.launch {
            // update loading
            updateIsLoading(true)

            // fetch
            try {
                updateMeals(
                    getAllMealsUseCase().map {
                        it.toUiState()
                    }
                )
            } catch (e: Exception) {
                updateIsLoading(false)
                updateErrorMessage(e.message ?: "something wrong happened")
            }

            // update loading and error
            updateIsLoading(false)

        }
    }

    private fun updateIsLoading(isLoading: Boolean) = _mainScreenUiState.update {
        it.copy(isLoading = isLoading)
    }

    private fun updateErrorMessage(errorMessage: String) = _mainScreenUiState.update {
        it.copy(errorMessage = errorMessage)
    }

    private fun updateMeals(meals: List<MealUiState>) = _mainScreenUiState.update {
        it.copy(meals = meals)
    }


    // ------------------ details screen
    private fun updateSelectedMeal(meal: MealUiState) {
        _selectedMeal.update { meal }
    }

    fun getMealById(id: Int) {
        viewModelScope.launch {
            updateSelectedMeal(
                getMealByIdUseCase(id).map { it.toUiState() }.first()
            )
        }
    }
}