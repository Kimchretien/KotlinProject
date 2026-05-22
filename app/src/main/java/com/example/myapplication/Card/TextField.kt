package com.example.myapplication.Card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun TextField(){
    var rechercher by remember { mutableStateOf("") }
    var expanded =remember { mutableStateOf(false) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = rechercher,
            onValueChange = {
                rechercher = it
            },
            placeholder = {
                Row {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Champ de recherche")
                }

            },
            modifier = Modifier
                .weight(1f)
                .height(55.dp)
        )
        IconButton(onClick = { expanded.value= true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Filtres"
            )
        }

        DropdownMenu(

            expanded = expanded.value,
            onDismissRequest = { expanded.value= false },
            offset = DpOffset(x = 250.dp, y = 0.dp)
        ) {
            menuItem("Toutes")
            menuItem("Chaussures")
            menuItem("Vetements")
            menuItem("Electroniques")
            menuItem("Accessoires")
            menuItem("Gaming")
            menuItem("Livres")
        }
    }
}
@Composable
fun menuItem(title: String) {
    var selectedItem by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    DropdownMenuItem(
        text = {
            Text(
                title,
                color = if (selectedItem == title) Color(0XFF1C69C0) else Color.Black
            )
        },
        onClick = {
            selectedItem = title
            expanded = false
        }
    )
}
