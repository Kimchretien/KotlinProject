package com.example.myapplication.UIs.compose

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
import com.example.myapplication.R
import com.example.myapplication.modele.Producty

@Composable
fun GridPageVertical(
    selectedFilter: String,
    onAddToCart: (Producty) -> Unit,
    onShowMessage: (String) -> Unit
) {


    val products = listOf(

        Producty(
            "Jordan 19",
            120,
            R.drawable.jordanshoes,
            1,
            "Chaussures"
        ),

        Producty(
            "Samsung phone",
            500,
            R.drawable.smartphone,
            9,
            "Electroniques"
        ),

        Producty(
            "Mac Book",
            900,
            R.drawable.laptop,
            9,
            "Electroniques"
        ),

        Producty(
            "Rolex",
            9000,
            R.drawable.watch,
            8,
            "Accessoires"
        ),
        Producty(
            "Coffee Maker",
            700,
            R.drawable.coffeemaker,
            3,
            "Accessoires"
        ),
        Producty(
            "refrigerator",
            6000,
            R.drawable.refrigerator,
            3,
            "Accessoires"
        ),
        Producty(
            "samba",
            120,
            R.drawable.samba,
            8,
            "Chaussures"
        ),

        Producty(
            "smartphone",
            500,
            R.drawable.smartphone,
            4,
            "Electroniques"

        ),

        Producty(
            "Mac Book",
            900,
            R.drawable.laptop,
            4,
            "Electroniques"
        ),

        Producty(
            "Rolex",
            9000,
            R.drawable.watch,
            1,
            "Accessoires"
        ),
        Producty(
            "coffeemaker",
            700,
            R.drawable.coffeemaker,
            1,
            "Accessoires"
        ),
        Producty(
            "refrigerator",
            6000,
            R.drawable.refrigerator,
            3,
            "Accessoires"
        ),
        Producty(
            "T shirt",
            800,
            R.drawable.tshirt,
            6,
            "vetements"
        ),
        Producty(
            "Manettes",
            1000,
            R.drawable.gaming,
            6,
            "gaming"
        )


    )

    val filteredProducts =
        if (selectedFilter == "Toutes") {
            products
        } else {
            products.filter {
                it.categorie == selectedFilter
            }
        }

    Column {
        filteredProducts.chunked(2).forEach { rows ->

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
