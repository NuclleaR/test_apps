package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    Button button;
    TextView text;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(this);
        editText.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        int number;
        try {
            number = Integer.parseInt(editText.getText().toString());
            if(number % 2 == 0) {
                text.setText(R.string.text_even);
            } else {
                text.setText(R.string.text_odd);
            }
        } catch (NumberFormatException e) {
            text.setText(R.string.error_text);
            e.getStackTrace();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        text.setText(R.string.hello_text);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
