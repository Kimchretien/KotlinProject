package com.example.myapplication.UIs.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login_page(navController: NavController){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var Is_register by remember { mutableStateOf(false) }
    var ErrorMessage by remember { mutableStateOf("") }
    Column {
        TopAppBar(
            title = {Text("")},
            colors = TopAppBarDefaults.topAppBarColors(
                Color(0XFF1C69C0)
            )
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier.padding(2.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    2.dp, Color.DarkGray
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = {
                            Text("E-mail")
                        },
                        shape = RoundedCornerShape(160.dp),


                    )


                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text("Password")
                        },
                        shape = RoundedCornerShape(160.dp)

                    )


                    Spacer(modifier = Modifier.height(10.dp))
                   if(Is_register){
                       OutlinedTextField(
                        value = passwordConfirm,
                        onValueChange = { passwordConfirm = it },
                        placeholder = {
                            Text("Confirm password")
                        },
                        shape = RoundedCornerShape(160.dp)

                    )

                   }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.width(300.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                if(!email.contains("@gmail.com")){
                                    ErrorMessage="Invalid E-mail"

                                }else if (password.length<6){
                                    ErrorMessage="Password is too short"
                                } else if( Is_register && passwordConfirm !=password){
                                    ErrorMessage ="Password doesn't match"
                                }
                                else{
                                    navController.navigate("home")
                                }
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF1C69C0))
                        ) {
                            Text(if (Is_register) "Register" else "Login")

                        }
                        TextButton(onClick = {
                            Is_register=!Is_register
                        }) {
                            Text(
                                text = if (!Is_register) "Register" else "Login"
                            )

                        }
                        if (ErrorMessage.isNotEmpty()) {
                            Text(
                                text = ErrorMessage,
                                color = Color.Red
                            )
                        }
                    }

                }
            }

        }
    }

}