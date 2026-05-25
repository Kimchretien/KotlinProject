package com.example.myapplication.ViewModele

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
@Composable
fun SearchBarWithMenu(
    selectedFilter: String,
    onFilterChange: (String) -> Unit
) {

    var rechercher by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = rechercher,
            onValueChange = { rechercher = it },
            placeholder = {
                Row {
                    Icon(Icons.Default.Search, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Champ de recherche")
                }
            },
            modifier = Modifier
                .weight(1f)
                .height(55.dp),
            shape = RoundedCornerShape(160000.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0XFF1C69C0),
                unfocusedBorderColor = Color.Gray
            )
        )

        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreHoriz, contentDescription = null)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } ,
            offset = DpOffset(x = 230.dp, y = 0.dp)
        ) {

            MenuItem("Toutes", selectedFilter, onFilterChange) {
                expanded = false
            }

            MenuItem("Chaussures", selectedFilter, onFilterChange) {
                expanded = false
            }

            MenuItem("vetements", selectedFilter, onFilterChange) {
                expanded = false
            }

            MenuItem("Electroniques", selectedFilter, onFilterChange) {
                expanded = false
            }

             MenuItem("gaming", selectedFilter, onFilterChange) {
                    expanded = false
                }


        }
    }
}
@Composable
fun MenuItem(
    title: String,
    selectedFilter: String,
    onFilterChange: (String) -> Unit,
    onClose: () -> Unit
) {

    DropdownMenuItem(
        text = {
            Text(
                title,
                color = if (selectedFilter == title) Color(0xFF1C69C0)
                else Color.Black
            )
        },
        onClick = {
            onFilterChange(title)
            onClose()
        }
    )
}
