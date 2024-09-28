package com.github.boodyahmedhamdy.odcamitmealsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.screens.MainScreen
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.screens.MealDetailsScreen
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.theme.ODCAmitMealsAppTheme
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.viewmodels.MainScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ODCAmitMealsAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { 
                        CenterAlignedTopAppBar(
                            title = { Text(text = "Meals App") }
                        )
                    }
                ) { innerPadding ->
                    val viewmodel: MainScreenViewModel = viewModel()
                    val mainScreenUiState = viewmodel.mainScreenUiState.collectAsState()
                    val selectedMealUiState = viewmodel.selectedMeal.collectAsState()
                    NavHost(
                        navController = navController,
                        startDestination = "mainScreen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("mainScreen") {
                            MainScreen(
                                state = mainScreenUiState.value,
                                onMealItemClicked = {
                                    Log.d("MainActivity", "clicked on id: $it")
                                    viewmodel.getMealById(it)
                                    navController.navigate("mealDetailsScreen")
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable("mealDetailsScreen") {
                            MealDetailsScreen(
                                state = selectedMealUiState.value,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
