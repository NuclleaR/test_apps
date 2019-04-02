package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView result;
    EditText num1;
    EditText num2;

    final private double closeTo = 10.0;
    final String res = "Closest number to " + closeTo + " is: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        result = findViewById(R.id.textResult);

        num1 = findViewById(R.id.editText1);
        num2 = findViewById(R.id.editText2);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {


            double d1 = Double.parseDouble(num1.getText().toString());
            double d2 = Double.parseDouble(num2.getText().toString());

            if(Math.abs(closeTo - d1) > Math.abs(closeTo - d2)) {
                result.setText(res + d2);
            } else {
                result.setText(res + d1);
            }
        } catch (NumberFormatException e) {
            result.setText("Please input numbers");
            e.getStackTrace();
        }
    }
}
