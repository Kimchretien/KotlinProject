package com.example.myapplication.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.modele.Producty

@Composable
fun ProduitCard(producty: Producty) {

    Card(
        modifier = Modifier
            .width(160.dp)
            .heightIn(max = 220.dp)
    ) {

        Column {

            // IMAGE EN HAUT
            Image(
                painter = painterResource(id = producty.image),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            // BAS (prix + bouton)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = producty.price,
                    fontWeight = FontWeight.ExtraBold
                )

                ClickableIconExample()
            }
        }
    }
}

@Composable
fun ClickableIconExample() {

    IconButton(onClick = {
       // println("Icône cliquée !")
    }) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Panier",
            tint = Color.Black
        )
    }
}