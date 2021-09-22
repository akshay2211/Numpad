package io.ak1.numpad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Created by akshay on 22/09/21
 * https://ak1.io
 */


@Composable
fun TextBox(modifier: Modifier, text: String, callback: (type: NumType, number: Int) -> Unit) {
    Button(
        modifier = modifier, onClick = {
            callback(NumType.NUMBER,text.toInt())
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}


@Composable
fun TextRow(modifierRow: Modifier, contentModifier: Modifier, range: IntRange,callback: (type: NumType, number: Int) -> Unit) {
    Row(modifier = modifierRow) {
        for (i in range) {
            TextBox(text = i.toString(), modifier = contentModifier,callback = callback)
        }
    }
}

@Composable
fun CustomRow(
    modifierRow: Modifier,
    contentModifier: Modifier,
    allowDecimal: Boolean,
    backPressIcon: Int,
    callback: (type: NumType, number: Int) -> Unit
) {
    val decimalText = if (allowDecimal) "." else " "
    Row(modifier = modifierRow) {
        TextBox(text = decimalText, modifier = contentModifier,callback = callback)
        TextBox(text = "0", modifier = contentModifier,callback = callback)
        Button(
            shape = MaterialTheme.shapes.small,
            modifier = contentModifier, onClick = {
                callback(NumType.DELETE,0)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Image(painter = painterResource(backPressIcon), contentDescription = "backpress")
        }
    }
}