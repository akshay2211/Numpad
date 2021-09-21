package com.fxn769.numpaddemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fxn769.Numpad;

public class MainActivity extends AppCompatActivity {
    TextView txt, remaining_digit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.hideStatusbar(this);
        setContentView(R.layout.activity_main);
        final Numpad numpad = findViewById(R.id.num);
        txt = findViewById(R.id.txt);
        remaining_digit = findViewById(R.id.remaining_digit);
        remaining_digit.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/custom_font.ttf"));
        txt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/custom_font_bold.ttf"));
        numpad.setOnTextChangeListner((String text, int digits_remaining) -> {
            if (text.length() == 0) {
                remaining_digit.setText("");
            } else {
                remaining_digit.setText("Remaining digits: " + digits_remaining + "/" + numpad.getTextLengthLimit());
            }
            txt.setText(text);
        });
    }

}
//<div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
