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
import com.example.myapplication.Card.ProductCard

@Composable
fun GridPageVertical(products :List<String>) {

    Column {

        products.chunked(2).forEach { rows ->

        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rows.forEach { product ->
                    Box(modifier = Modifier.weight(1f)) {
                        ProductCard(product)
                    }
                    }
                }
            Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
