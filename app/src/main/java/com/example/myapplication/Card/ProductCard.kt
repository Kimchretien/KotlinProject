package com.example.myapplication.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.modele.Category

@Composable
fun CategoryCard(category: Category) {

    Card(
        modifier = Modifier
            .width(110.dp)
            .height(120.dp),
        onClick = { }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    imageVector = category.icon,
                    contentDescription = category.name,
                    tint = Color(0xFF6750A4)
                )

                Text(category.name,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}