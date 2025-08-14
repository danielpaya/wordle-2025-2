package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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

// --- AÑADIR al final de Cell.kt ---

@Composable
fun RowScope.KeyboardKey(
    label: String,
    weight: Float = 1f,
    onKey: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .weight(weight)
            .height(52.dp)
            .background(Color(0xFF818384), RoundedCornerShape(6.dp))
            .clickable { onKey(label) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun Keyboard(
    onKey: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val row1 = listOf("Q","W","E","R","T","Y","U","I","O","P")
    val row2 = listOf("A","S","D","F","G","H","J","K","L","Ñ") // usa "L" si no quieres Ñ
    val row3 = listOf("ENTER") + listOf("Z","X","C","V","B","N","M") + listOf("⌫")

    val hGap = 6.dp
    val vGap = 8.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 8.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(vGap),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(hGap)) {
            row1.forEach { key -> KeyboardKey(label = key, onKey = onKey) }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(hGap)) {
            row2.forEach { key -> KeyboardKey(label = key, onKey = onKey) }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(hGap)) {
            row3.forEach { key ->
                val w = if (key.length > 1 || key == "⌫") 1.5f else 1f // ENTER y ⌫ más anchas
                KeyboardKey(label = key, weight = w, onKey = onKey)
            }
        }
    }
}

// (Opcional) Preview solo del teclado
@Preview(showBackground = true)
@Composable
fun PreviewKeyboard() {
    Column(Modifier.background(Color.Black).padding(16.dp)) {
        Keyboard(onKey = { /* no-op */ })
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