package com.lava.ldc.practicepworkshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    EditText start;
    EditText end;
    TextView output;
    Button btnGenerate;

    @Override
    protected void onResume() {
        super.onResume();

        start = (EditText) findViewById(R.id.start);
        end = (EditText) findViewById(R.id.end);
        output = (TextView) findViewById(R.id.output);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(start.getText().toString()) || TextUtils.isEmpty(end.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please do not leave any fields empty!", Toast.LENGTH_SHORT).show();
                } else {
                    int min = Integer.parseInt(start.getText().toString());
                    int max = Integer.parseInt(end.getText().toString());
                    Random random = new Random();
                    if (min > max) {
                        Toast.makeText(getApplicationContext(), "The minimum range value you entered is larger then the maximum range value!", Toast.LENGTH_LONG).show();
                    } else {
                        double randomMultiplier = random.nextDouble();
                        long range = (long) max - (long) min + 1;
                        int randomNumber = (int) ((long) (range * randomMultiplier) + min);
                        output.setText(Integer.toString(randomNumber));
                        /*Also possible replacement for performance improvement:
                        output.setText(String.format(Locale.getDefault(),"%d",randomNumber));*/
                    }
                }
            }
        });
    }
}
