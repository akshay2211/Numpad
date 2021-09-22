package io.ak1.numpad

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

/**
 * Created by akshay on 20/09/21
 * https://ak1.io
 */

@Composable
fun Numpad(modifier_outer: Modifier = Modifier) {
    val (color, setColor) = remember { mutableStateOf(Color.White) }
    val modifier =
        Modifier
            .fillMaxHeight()
            .background(color = color)
            .padding(2.dp)

    val fullWidthModifier = Modifier
        .fillMaxSize()
    Column(modifier = modifier_outer, verticalArrangement = Arrangement.SpaceEvenly) {
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            contentModifier = modifier.weight(1f, true), range = 1..3
        )
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            contentModifier = modifier.weight(1f, true), range = 4..6
        )
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            contentModifier = modifier.weight(1f, true), range = 7..9
        )

        CustomRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            contentModifier = modifier.weight(1f, true),
            allowDecimal = true,
            backPressIcon = R.drawable.ic_delete
        )
    }

}
fun onClick(text: String) = object : () -> Unit {
    override fun invoke() {
        Log.e("hello", "invoke $text")
    }
}



