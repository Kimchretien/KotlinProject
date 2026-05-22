package com.example.myapplication.Card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterSection() {

    Row {

        FilterChip(
            selected = true,
            onClick = {},
            label = {
                Text("Chaussures")
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0XFF1C69C0),
                selectedLabelColor = Color.White,
                containerColor = Color.LightGray,
                labelColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterChip(
            selected = true,
            onClick = {},
            label = {
                Text("Vetements")
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0XFF1C69C0),
                selectedLabelColor = Color.White,
                containerColor = Color.LightGray,
                labelColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterChip(
            selected = true,
            onClick = {},
            label = {
                Text("Accessoires")
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = Color(0XFF1C69C0),
                selectedLabelColor = Color.White,
                containerColor = Color.LightGray,
                labelColor = Color.Black
            )
        )
    }
}
