package com.github.boodyahmedhamdy.odcamitmealsapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.boodyahmedhamdy.odcamitmealsapp.R
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MealUiState

@Composable
fun MealDetailsScreen(
    modifier: Modifier = Modifier,
    state: MealUiState = MealUiState()
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // image
        AsyncImage(
            model = state.imageUrl,
            contentDescription = state.title,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier.fillMaxWidth()
        )

        // title
        Text(text = state.title, style = MaterialTheme.typography.headlineLarge)

        // area
        Text(text = "${state.area} - ${state.category}", modifier = Modifier.alpha(0.7f))

        // description
        Text(text = state.instructions)


        Text(text = "Ingredients and Measures", style = MaterialTheme.typography.headlineMedium)
        state.ingredients.forEachIndexed { index, ingredient ->
            if(ingredient.isNotEmpty()) {
                Text(text = "${state.measures[index]} -> $ingredient", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
            }
        }

    }



}


@Preview
@Composable
private fun MealDetailsScreenPreview() {
    MealDetailsScreen(
        modifier = Modifier.fillMaxSize()
    )
}