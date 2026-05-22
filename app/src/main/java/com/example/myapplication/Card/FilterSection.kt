package com.example.myapplication.Card

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterSection() {
    var selectedFilter=remember { mutableStateOf("Chaussures") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .horizontalScroll(rememberScrollState())
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Filterchip(
                name = "Chaussures",
                selected = selectedFilter.value== "Chaussures",
                onClick = { selectedFilter.value= "Chaussures" }
            )

            Filterchip(
                name = "Vetements",
                selected = selectedFilter.value== "Vetements",
                onClick = { selectedFilter.value= "Vetements" }
            )

            Filterchip(
                name = "Electronique",
                selected = selectedFilter.value== "Electronique",
                onClick = { selectedFilter.value= "Electronique" }
            )
        }


    }
}

@Composable
fun Filterchip(
    name: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(name) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0XFF1C69C0),
            selectedLabelColor = Color.White,
            containerColor = Color.Transparent,
            labelColor = Color.Black
        )
    )
}