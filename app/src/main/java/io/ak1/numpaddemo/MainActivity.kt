package io.ak1.numpaddemo


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ak1.numpad.BasicConfigs
import io.ak1.numpad.NumType
import io.ak1.numpad.Numpad
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                content = {
                    Surface(color = MaterialTheme.colors.background) {
                        MainScreen()
                    }
                }
            )
        }
    }

    @Preview
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }


    @Composable
    fun MainScreen() {
        var config = MutableStateFlow(BasicConfigs.Config1.getConfig().apply {
            fontFamily = FontFamily(Font(R.font.quicksand_light))
        })
        //  var testText = MutableStateFlow("")
        val (text, setText) = remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f, true)) {
                Text(
                    text = text,//testText.value,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.satisfy_regular)),
                    fontSize = 30.sp
                )
                Image(
                    modifier = Modifier
                        .clickable {
                            //   testText.value += "| " + testText.value
                            config.value = BasicConfigs.Config2
                                .getConfig()
                                .apply {
                                    fontFamily = FontFamily(Font(R.font.satisfy_regular))
                                }

                        }
                        .padding(20.dp)
                        .align(Alignment.TopEnd),
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = "config_icon"
                )
            }

            Numpad(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                configuration = config.collectAsState().value
            ) { type, num ->
                if (type == NumType.NUMBER && text.length < 5) {
                    val txt = text + num
                    setText("$txt")
                } else if (type == NumType.DELETE && text.isNotEmpty()) {
                    setText(text.substring(0, text.length - 1))
                }
            }
        }
    }
}