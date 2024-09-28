package com.github.boodyahmedhamdy.odcamitmealsapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.components.MealListItem
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MainScreenUiState
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MealUiState

@Composable
fun MainScreen(
    state: MainScreenUiState,
    modifier: Modifier = Modifier,
    onMealItemClicked: (Int) -> Unit = {}
) {
    if(state.isLoading) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            CircularProgressIndicator(modifier = modifier)
        }

    } else {
        LazyColumn(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(state.meals) {
                MealListItem(
                    state = it,
                    onClick = { onMealItemClicked(it) },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

            if(state.errorMessage.isNotEmpty()) {
                item {
                    Text(text = state.errorMessage, color = MaterialTheme.colorScheme.error)
                }
            }

        }
    }



}


