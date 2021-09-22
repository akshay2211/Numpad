package io.ak1.numpad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

/**
 * Created by akshay on 22/09/21
 * https://ak1.io
 */


@Composable
fun TextBox(modifier: Modifier, text: String) {
    Box(modifier, contentAlignment = Alignment.Center) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}

@Composable
fun TextRow(modifierRow: Modifier, contentModifier: Modifier, range: IntRange) {
    Row(
        modifier = modifierRow
    ) {
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
    Row(
        modifier = modifierRow
    ) {
        TextBox(text = decimalText, modifier = contentModifier)
        TextBox(text = "0", modifier = contentModifier)
        Box(contentModifier, contentAlignment = Alignment.Center) {
            Image(painter = painterResource(backPressIcon), contentDescription = "backpress")
        }
    }
}