package com.example.myapplication.Compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Snowshoeing
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.myapplication.Card.CategoryCard
import com.example.myapplication.modele.Category

@Composable
fun GridRow() {

    val categories = listOf(
        Category("Vetements", Icons.Default.Checkroom),
        Category("Chaussures", Icons.Default.Snowshoeing),
        Category("Accessoires", Icons.Default.ShoppingBag),
        Category("Electroniques", Icons.Default.PhoneAndroid),
        Category("Gaming", Icons.Default.SportsEsports)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {

        items(categories) { product ->

           CategoryCard(product)
            }
        }
    }