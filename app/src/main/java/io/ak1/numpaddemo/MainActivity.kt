package io.ak1.numpaddemo


import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ak1.numpad.Numpad

class MainActivity : AppCompatActivity() {
    var txt: TextView? = null
    var remaining_digit: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                content = {
                    Surface(color = MaterialTheme.colors.background) {
                        Numpad(modifier_outer = Modifier.fillMaxWidth().height(300.dp))
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