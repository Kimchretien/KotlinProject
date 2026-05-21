package com.example.myapplication.UIs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember{ mutableStateOf("") }
    var isVisible by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Bienvenu dans l'application",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it

            },
            label = {
                Text("email")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it

            },
            label = {
                Text("password")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (!isVisible) {
            OutlinedTextField(
                value = passwordConfirm,
                onValueChange = {
                    passwordConfirm = it
                },
                label = {
                    Text("Password confirm")
                }
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        if (isVisible) {
            Button(
                onClick = {
                    if (!email.contains("@gmail.com")) {
                        errorMessage = "Invalid Email"
                    } else if (password.length < 6) {
                        errorMessage = "Password must >6 caractere"
                    } else {
                        navController.navigate("home")
                    }
                }
            ) {
                Text("Connexion")
            }
        } else {
            Button(
                onClick = {}
            ) {
                Text("Create")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = errorMessage
        )
        Spacer(modifier = Modifier.height(5.dp))
        if (isVisible) {
            Text(
                text = "create a account",
                modifier = Modifier.clickable {
                    isVisible = false
                }
            )
        } else {
            Text(
                text = "Connexion",
                modifier = Modifier.clickable {
                    isVisible = true
                }
            )
        }
    }

}