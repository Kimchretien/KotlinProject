package com.example.myapplication.UIs.compose

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterSection(
    selectedFilter: String,
    onFilterChange: (String) -> Unit
) {

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
                name = "Toutes",
                selected = selectedFilter == "Toutes",
                onClick = {
                    onFilterChange("Toutes")
                }
            )

            Filterchip(
                name = "Chaussures",
                selected = selectedFilter == "Chaussures",
                onClick = {
                    onFilterChange("Chaussures")
                }
            )

            Filterchip(
                name = "vetements",
                selected = selectedFilter == "vetements",
                onClick = {
                    onFilterChange("vetements")
                }
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
            selectedContainerColor = Color(0xFF2196F3),
            selectedLabelColor = Color.White,
            containerColor = Color.Transparent,
            labelColor = Color.Black
        )
    )
}