package com.example.myapplication.Card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.modele.Producty

@Composable
fun ProduitCard(
    producty: Producty,
    onAddToCart: (Producty) -> Unit,
    onShowMessage: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(230.dp)
            .padding(5.dp),

        shape = RoundedCornerShape(20.dp),

        border = BorderStroke(
            2.dp,
            Color.DarkGray
        ),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {
                Image(
                    painter = painterResource(id = producty.image),
                    modifier = Modifier.fillMaxWidth().height(150.dp).clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                    ),
                    contentDescription=null,
                    contentScale = ContentScale.Crop

                )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                Text(
                    text = "${producty.price} BIF",
                    modifier = Modifier.align(Alignment.BottomStart),
                    fontSize = 18.sp
                )

                IconButton(
                    onClick = {
                        if(producty.nombre>0){
                            producty.nombre--
                        } else{
                            onShowMessage("Stock épuisé ❌")
                            return@IconButton
                        }
                        onAddToCart(producty)
                    },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {

                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "cart",
                        tint = Color.Black
                    )
                }
            }
        }

    }
}
