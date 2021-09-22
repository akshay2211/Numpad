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
fun TextBox(modifier: Modifier, text: String) {
    Button(
        modifier = modifier, onClick = onClick(text),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}


@Composable
fun TextRow(modifierRow: Modifier, contentModifier: Modifier, range: IntRange) {
    Row(modifier = modifierRow) {
        for (i in range) {
            TextBox(text = i.toString(), modifier = contentModifier)
        }
    }
}

@Composable
fun CustomRow(
    modifierRow: Modifier,
    contentModifier: Modifier,
    allowDecimal: Boolean,
    backPressIcon: Int
) {
    val decimalText = if (allowDecimal) "." else " "
    Row(modifier = modifierRow) {
        TextBox(text = decimalText, modifier = contentModifier)
        TextBox(text = "0", modifier = contentModifier)
        Button(
            modifier = contentModifier, onClick = onClick("delete"),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Image(painter = painterResource(backPressIcon), contentDescription = "backpress")
        }
    }
}