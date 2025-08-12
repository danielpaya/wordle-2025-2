package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class CellType{
    GREEN,
    YELLOW,
    GREY,
    TRANSPARENT
}

@Composable
fun Cell(character: String, blockType: CellType) {

    val (bgColor, borderColor) = when (blockType) {
        CellType.GREEN  -> Color(0xFF6AAA65) to Color(0xFF6AAA65)   // puedes usar el mismo para borde
        CellType.YELLOW -> Color(0xFFC9B457) to Color(0xFFC9B457)
        CellType.GREY   -> Color(0xFF787C7F) to Color(0xFF787C7F)
        CellType.TRANSPARENT -> Color.Transparent to Color(0xFF3A3A3C) // borde gris para vacías
    }

    val shape = RoundedCornerShape(4.dp)

    Box(
        modifier = Modifier
            .size(56.dp)
            .background(bgColor, shape)                       // fondo
            .border(2.dp, borderColor, shape),                // <-- contorno visible
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = character.uppercase(),
            fontSize = 22.sp,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun PreviewCellSuccess(){
    Column {
        Row{
            Cell("H", CellType.GREEN)
            Cell("E", CellType.GREY)
            Cell("L", CellType.YELLOW)
            Cell("L", CellType.GREEN)
            Cell("O", CellType.TRANSPARENT)
        }

        Row{
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
        }
    }
}

@Composable
fun Board(
    rows: List<List<Pair<String, CellType>>>,
    gap: Dp = 6.dp
){
    Column(
        verticalArrangement = Arrangement.spacedBy(gap),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        rows.forEach{ row ->
            Row(horizontalArrangement = Arrangement.spacedBy(gap)){
                row.forEach { (ch, type)-> Cell(ch, type)}
            }

        }
    }
}
//
//@Preview
//@Composable
//fun PreviewCellMissing(){
//    Cell("W", 0)
//}
//
//@Preview
//@Composable
//fun PreviewCellNoInWord(){
//    Cell("W", 2)
//}

// "basd" -> String
// 'a' -> Char


// String -> Char[]

// Hola -> H,O,L,A .toString()