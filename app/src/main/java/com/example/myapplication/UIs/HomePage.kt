package com.example.myapplication.UIs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Compose.GridLazyColumn
import com.example.myapplication.Compose.GridPageVertical


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomePage(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title ={
                    Text("Home page")
                },

            actions = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "Back")
                }
            }

            )
        },
        bottomBar ={
        NavigationBar {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "home"
                    )
                },
                label = { Text("Profile") }
            )
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "settings"
                    )
                },
                label = { Text("Settings") }
            )
        }},
        floatingActionButton ={
            FloatingActionButton(
                onClick = {

                }
            ) {
                Icon(Icons.Default.Add , contentDescription = "Add")
            }
        }

    ) { paddingValues ->

       GridLazyColumn(paddingValues)
    }




}
