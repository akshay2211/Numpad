package io.ak1.numpaddemo


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ak1.numpad.BasicConfigs
import io.ak1.numpad.Configuration
import io.ak1.numpad.NumType
import io.ak1.numpad.Numpad

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                content = {
                    Surface(color = MaterialTheme.colors.background) {
                        val (text, setText) = remember { mutableStateOf("") }
                        Column(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = text,
                                modifier = Modifier
                                    .weight(1f, true)
                                    .padding(20.dp),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.quicksand_light)),
                                fontSize = 30.sp)
                        Numpad(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(330.dp),
                            configuration = BasicConfigs.Config1.getConfig()
                        ) { type, num ->
                            if (type == NumType.NUMBER && text.length<5) {
                                val txt = text + num
                                setText("$txt")
                            } else if (type == NumType.DELETE && text.isNotEmpty()) {
                                setText(text.substring(0, text.length - 1))
                            }
                        }
                    }

                }
        }
        )
    }
}
}