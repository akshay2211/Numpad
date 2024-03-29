package io.ak1.numpad

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by akshay on 20/09/21
 * https://ak1.io
 */

enum class NumType {
    NUMBER, DELETE
}

data class Configuration(
    var color: Color = Color.Unspecified,
    var fontSize: TextUnit = TextUnit.Unspecified,
    var fontStyle: FontStyle? = null,
    var fontWeight: FontWeight? = null,
    var fontFamily: FontFamily? = null,
    @DrawableRes
    var deleteIcon: Int = R.drawable.ic_delete,
    var cornerRadius: Dp = 0.dp,
    var inner_modifier: Modifier = Modifier
        .fillMaxHeight()
        .background(color = color)
        .padding(2.dp)
)

sealed class BasicConfigs {
    // Sample Configuration One
    object Config1 : BasicConfigs() {
        fun getConfig(): Configuration {
            return Configuration().apply {
                color = Color.Blue
              //  fontFamily = FontFamily(Font(R.font.quicksand_light))
                fontSize = 30.sp
            }
        }
    }
    // Sample Configuration Two
    object Config2 : BasicConfigs() {
        fun getConfig(): Configuration {
            return Configuration().apply {

            }
        }
    }
    // Sample Configuration Three
    object Config3 : BasicConfigs() {
        fun getConfig(): Configuration {
            return Configuration().apply {

            }
        }
    }

}


@Composable
fun Numpad(
    modifier: Modifier = Modifier,
    configuration: Configuration,
    callback: (type: NumType, number: Int) -> Unit
) {
    val fullWidthModifier = Modifier.fillMaxSize()
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            configuration = configuration, range = 1..3, callback = callback
        )
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            configuration = configuration, range = 4..6, callback = callback
        )
        TextRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            configuration = configuration, range = 7..9, callback = callback
        )

        CustomRow(
            modifierRow = fullWidthModifier.weight(1f, true),
            configuration = configuration, callback = callback
        )
    }
}



