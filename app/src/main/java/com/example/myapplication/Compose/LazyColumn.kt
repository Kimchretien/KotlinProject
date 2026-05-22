package com.example.myapplication.Compose

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.modele.Producty
import java.nio.file.DirectoryStream.Filter

@Composable
fun GridLazyColumn(selectedFilter: String,onAddToCart: (Producty) -> Unit,onShowMessage: (String) -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            GridPageVertical(selectedFilter = selectedFilter,onAddToCart = onAddToCart, onShowMessage =onShowMessage )
        }
    }
}

