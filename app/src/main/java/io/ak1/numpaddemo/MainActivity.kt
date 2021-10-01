package io.ak1.numpaddemo


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                        var configs = remember { BasicConfigs.Config1.getConfig() }

                        Column(modifier = Modifier.fillMaxSize()) {
                            Box(modifier = Modifier.weight(1f, true)) {
                                Text(
                                    text = text,
                                    modifier = Modifier
                                        .padding(20.dp),
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.quicksand_light)),
                                    fontSize = 30.sp)
                                Image(modifier = Modifier.clickable {
                                    configs = BasicConfigs.Config2.getConfig()
                                },
                                    painter = painterResource(R.drawable.ic_settings),
                                    contentDescription = "config_icon"
                                )
                            }

                        Numpad(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(330.dp),
                            configuration = configs
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
    /*@Composable
    fun mainView(){
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f, true)) {
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(20.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.quicksand_light)),
                    fontSize = 30.sp)
                Image(modifier = Modifier.clickable {
                    configs = BasicConfigs.Config2.getConfig()
                },
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = "config_icon"
                )
            }

            Numpad(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                configuration = configs
            ) { type, num ->
                if (type == NumType.NUMBER && text.length<5) {
                    val txt = text + num
                    setText("$txt")
                } else if (type == NumType.DELETE && text.isNotEmpty()) {
                    setText(text.substring(0, text.length - 1))
                }
            }
        }
    }*/
}