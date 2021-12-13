package com.example.sanssystechnology.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview
@Composable
fun AboutUs (navController: NavController,navigate:String) {
    Box( modifier = Modifier.fillMaxWidth()) {
        Text(text = "About Us Page")
    }

}