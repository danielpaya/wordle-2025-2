package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unisabana.wordle.presentation.components.Board
import com.unisabana.wordle.presentation.components.CellType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(){
    Scaffold (
        containerColor = Color(0xFF000000),
        topBar= {
            CenterAlignedTopAppBar(
                title = { Text("WORDLE")},
                navigationIcon = {
                    IconButton(onClick = {/* TODO: back*/}){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atras"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {/* TODO: menú*/}){
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Más opciones"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1E1E1E),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },

        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ){
                Spacer(Modifier.height(60.dp))

                val demo = listOf(

                    List(5) { "" to CellType.TRANSPARENT },
                    List(5) { "" to CellType.TRANSPARENT },
                    List(5) { "" to CellType.TRANSPARENT },
                    List(5) { "" to CellType.TRANSPARENT },
                    List(5) { "" to CellType.TRANSPARENT },
                    List(5) { "" to CellType.TRANSPARENT }
                )

                Board(rows = demo)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    GameScreen()
}