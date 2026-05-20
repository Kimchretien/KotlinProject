package com.example.myapplication.Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridLazyColumn(paddingValues: PaddingValues){
    LazyColumn(
        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        item{
            Text(
                text = "Categorie",
                modifier = Modifier.padding(start =  12.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item{
            GridRow(products = listOf("Vetements","Chaussures","Accesoires","Electroniques","Gaming"))
        }
        item {
            Text(
                text = "Produits Populaires",
                modifier = Modifier.padding(start =  12.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            GridPageVertical(products = listOf("Chaussures Jordan","Frigo","Telephone","montre",
                "cafetiare","OrdinateurHP"))
        }

        item {
            Text(
                text = "Nouveautes",
                modifier = Modifier.padding(start =  12.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            GridPageVertical(products = listOf("Ordinateur MacBook","Jordan19","Television",
                "Telephones"))
        }
    }
}