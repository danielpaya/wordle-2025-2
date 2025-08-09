package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Scaffold {
            innerPadding ->
        Text("Hola Home", modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun Tutorial(){

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}