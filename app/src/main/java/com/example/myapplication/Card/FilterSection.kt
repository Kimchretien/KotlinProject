package com.example.myapplication.Card

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
    var expanded =remember { mutableStateOf(false) }

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

            Filterchip("Chaussures")
            Filterchip("Vetements")
            Filterchip("Electronique")
        }

        IconButton(onClick = { expanded.value= true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Filtres"
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value= false }
        ) {
            DropdownMenuItem(
                text = { Text("Chaussures") },
                onClick = { expanded.value= false }
            )
            DropdownMenuItem(
                text = { Text("Vêtements") },
                onClick = { expanded.value= false }
            )
            DropdownMenuItem(
                text = { Text("Accessoires") },
                onClick = { expanded.value= false }
            )
        }
    }
}

@Composable
fun Filterchip(name: String) {
    FilterChip(
        selected = true,
        onClick = {},
        label = { Text(name) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0XFF1C69C0),
            selectedLabelColor = Color.White,
            containerColor = Color.LightGray,
            labelColor = Color.Black
        )
    )
}