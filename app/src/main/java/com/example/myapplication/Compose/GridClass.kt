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
fun GridPageVertical(
    onAddToCart: (Producty) -> Unit,
    onShowMessage: (String) -> Unit
) {

    val products = listOf(

        Producty(
            120,
            R.drawable.jordanshoes,
            1
        ),

        Producty(
            500,
            R.drawable.smartphone,
            9
        ),

        Producty(
            900,
            R.drawable.laptop,
            9
        ),

        Producty(
            9000,
            R.drawable.watch,
            8
        ),
        Producty(
            700,
            R.drawable.coffeemaker,
            3
        ),
        Producty(
            6000,
            R.drawable.refrigerator,
            3
        ),
        Producty(
            120,
            R.drawable.jordanshoes,
            3
        ),

        Producty(
            500,
            R.drawable.smartphone,
            4

        ),

        Producty(
            900,
            R.drawable.laptop,
            4
        ),

        Producty(
            9000,
            R.drawable.watch,
            1
        ),
        Producty(
            700,
            R.drawable.coffeemaker,
            1
        ),
        Producty(
            6000,
            R.drawable.refrigerator,
            3
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
                        ProduitCard(
                            producty = product,
                            onAddToCart = onAddToCart,
                            onShowMessage=onShowMessage
                        )
                    }
                    }
                }
            Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
