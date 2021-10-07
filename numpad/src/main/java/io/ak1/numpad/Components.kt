package io.ak1.numpad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun TextBox(
    modifier: Modifier,
    text: String,
    configuration: Configuration,
    callback: (type: NumType, number: Int) -> Unit
) {
    Button(
        modifier = modifier, onClick = {
            if (!text.trim().isNullOrEmpty()) {
                callback(NumType.NUMBER, text.toInt())
            }
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Text(
            text = text,
            fontFamily = configuration.fontFamily,
            fontSize = configuration.fontSize,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun TextRow(
    modifierRow: Modifier,
    configuration: Configuration,
    range: IntRange,
    callback: (type: NumType, number: Int) -> Unit
) {
    Row(modifier = modifierRow) {
        for (i in range) {
            TextBox(
                text = i.toString(),
                modifier = configuration.inner_modifier.weight(1f, true),
                configuration = configuration,
                callback = callback
            )
        }
    }
}

@Composable
fun CustomRow(
    modifierRow: Modifier,
    configuration: Configuration,
    callback: (type: NumType, number: Int) -> Unit
) {
    Row(modifier = modifierRow) {
        TextBox(
            text = " ",
            modifier = configuration.inner_modifier.weight(1f, true),
            configuration = configuration,
            callback = callback
        )
        TextBox(
            text = "0",
            modifier = configuration.inner_modifier.weight(1f, true),
            configuration = configuration,
            callback = callback
        )
        Button(
            shape = RoundedCornerShape(configuration.cornerRadius),
            modifier = configuration.inner_modifier.weight(1f, true), onClick = {
                callback(NumType.DELETE, 0)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Image(
                painter = painterResource(configuration.deleteIcon),
                contentDescription = "delete_icon"
            )
        }
    }
}