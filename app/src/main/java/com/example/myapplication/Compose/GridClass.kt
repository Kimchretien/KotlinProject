package com.example.myapplication.Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.Card.ProduitCard
import com.example.myapplication.R
import com.example.myapplication.modele.Producty

@Composable
fun GridPageVertical() {

    val products = listOf(

        Producty(
            120,
            R.drawable.jordanshoes,
        ),

        Producty(
            500,
            R.drawable.smartphone,
        ),

        Producty(
            900,
            R.drawable.laptop,
        ),

        Producty(
            9000,
            R.drawable.watch,
        ),
        Producty(
            700,
            R.drawable.coffeemaker,
        ),
        Producty(
            6000,
            R.drawable.refrigerator,
        )

    )

    Column {
        products.chunked(2).forEach { rows ->

        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rows.forEach { product ->
                    Box(modifier = Modifier.weight(1f)) {
                        ProduitCard(product)
                    }
                    }
                }
            Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
