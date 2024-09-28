package com.github.boodyahmedhamdy.odcamitmealsapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.boodyahmedhamdy.odcamitmealsapp.R
import com.github.boodyahmedhamdy.odcamitmealsapp.ui.states.MealUiState

@Composable
fun MealListItem(
    state: MealUiState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier.clickable {
            onClick(state.id.toInt())
        }.shadow(4.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {

        AsyncImage(
            model = state.imageUrl,
            contentDescription = state.title,
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
                .clip(CircleShape),
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )

        Text(
            text = state.title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

    }



}