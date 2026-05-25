package com.example.myapplication.UIs.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun login_page(){

    var email by remember{ mutableStateOf("") }
    Column {
        OutlinedTextField(
            value = email,
            onValueChange = {email=it}
        )
    }
}