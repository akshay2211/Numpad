package io.ak1.numpaddemo


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                            OutlinedTextField(value = text, onValueChange = {
                                Log.e("onValueChange", "-> $it")
                            }, modifier = Modifier.fillMaxWidth().weight(1f,true))
                            Numpad(
                                modifier_outer = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp)
                            ) { type, num ->
                                if (type == NumType.NUMBER) {
                                    val txt = text + num
                                    setText("${txt}")
                                } else if (type == NumType.DELETE) {
                                    setText(text.substring(0,text.length - 1))
                                }
                            }
                        }

                    }
                }
            )
        }
        /*
            Utils.hideStatusbar(this)
            setContentView(R.layout.activity_main)
            val numpad = findViewById<Numpad>(R.id.num)
            txt = findViewById(R.id.txt)
            remaining_digit = findViewById(R.id.remaining_digit)
            remaining_digit?.setTypeface(Typeface.createFromAsset(assets, "fonts/custom_font.ttf"))
            txt?.setTypeface(Typeface.createFromAsset(assets, "fonts/custom_font_bold.ttf"))
            numpad.setOnTextChangeListner { text: String, digits_remaining: Int ->
                if (text.length == 0) {
                    remaining_digit?.setText("")
                } else {
                    remaining_digit?.setText("Remaining digits: " + digits_remaining + "/" + numpad.textLengthLimit)
                }
                txt?.setText(text)
            }*/
    }
}