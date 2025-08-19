package com.unisabana.wordle.presentation.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun GameScreen() {
    Scaffold(
        containerColor = Color(0xFF000000),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("WORDLE") },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: back */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: menú */ }) {
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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(60.dp))


            val demo = List(6) { List(5) { "" to CellType.TRANSPARENT } }
            Board(rows = demo)

            Spacer(Modifier.height(50.dp))


            Keyboard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
private fun Keyboard(modifier: Modifier = Modifier) {
    val row1 = "QWERTYUIOP".map { it.toString() }
    val row2 = "ASDFGHJKLÑ".map { it.toString() } // usa "ASDFGHJKL" si no quieres Ñ
    val row3 = "ZXCVBNM".map { it.toString() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            row1.forEach { KeyButton(it, Modifier.weight(1f)) }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Spacer(Modifier.weight(0.5f))
            row2.forEach { KeyButton(it, Modifier.weight(1f)) }
            Spacer(Modifier.weight(0.5f))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            KeyButton("ENTER", Modifier.weight(1.5f))
            row3.forEach { KeyButton(it, Modifier.weight(1f)) }
            DeleteKey(Modifier.weight(1.5f))
        }
    }
}

@Composable
private fun KeyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* TODO: manejar tecla */ },
        modifier = modifier.height(42.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3A3A3C),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text)
    }
}

@Composable
private fun DeleteKey(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* TODO: borrar */ },
        modifier = modifier.height(42.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3A3A3C),
            contentColor = Color.White
        )
    ) {
        Text("⌫")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    GameScreen()
}
