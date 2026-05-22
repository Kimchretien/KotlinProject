package com.example.myapplication.UIs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.Card.FilterSection
import com.example.myapplication.Card.TextField
import com.example.myapplication.Compose.GridLazyColumn
import com.example.myapplication.modele.Producty
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomePage() {
    val cart = remember {
        mutableStateOf<List<Producty>>(emptyList())
    }
    val total = cart.value.sumOf { it.price }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val selectedFilter = remember {
        mutableStateOf("Toutes")
    }

    fun showMessage(message: String) {
        scope.launch {
            snackbarHostState.showSnackbar(message)
        }
    }
    Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },

        topBar = {

            Box(
               modifier = Modifier.fillMaxWidth().background(Color(0xFF1C69C0))
            )
            {
                TopAppBar(
                    title = {
                        Text("")
                    },
                    modifier = Modifier.statusBarsPadding()
                        .clip(
                            RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                        ),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF1C69C0)
                    )
                )
            }
        },


        bottomBar = {

            BottomAppBar(
                modifier = Modifier.clip(
                    RoundedCornerShape(
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                ),
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "$total BIF", fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif, fontSize = 28.sp)

                    Spacer(modifier = Modifier.weight(1f))

                    Button(onClick = { }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1C69C0)
                    )) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "cart"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Cart")
                    }
                }
            }
        }
    ){ paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize().padding(horizontal = 8.dp),


        ) {
            Spacer(modifier = Modifier.height(20.dp))
            TextField()
            Spacer(modifier = Modifier.height(20.dp))
            FilterSection(
                selectedFilter = selectedFilter.value,
                onFilterChange = {
                    selectedFilter.value = it
                }
            )
            GridLazyColumn(selectedFilter = selectedFilter.value,
                onAddToCart = { product ->
                    cart.value = cart.value + product
                },   onShowMessage = { message ->
                    showMessage(message)
                }
            )
        }

    }




}
