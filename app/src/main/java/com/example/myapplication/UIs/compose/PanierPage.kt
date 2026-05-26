package com.example.myapplication.UIs.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.modele.Producty

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(
    cart: List<Producty>,
    onRemove: (Producty) -> Unit,
    onBack: () -> Unit
) {

    val total = cart.sumOf { it.price }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("Panier")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3)
                ),

                navigationIcon = {

                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {

                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                }
            )
        },

        bottomBar = {

            BottomAppBar {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$total BIF",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        )
                    ){
                        Icon(
                            imageVector = Icons.Default.Payment,
                            contentDescription = "Buy"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Buy")
                    }
                }
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            items(cart) { product ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(product.name)

                        Text("${product.price} BIF")
                    }

                    IconButton(
                        onClick = {
                            onRemove(product)
                        }
                    ) {

                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}