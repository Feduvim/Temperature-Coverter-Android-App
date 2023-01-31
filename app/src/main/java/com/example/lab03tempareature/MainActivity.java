package com.example.lab03tempareature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String inputStr;
    private Double temperature;;
    private RadioButton rCelsius, rFahrenheit;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCelsius = (RadioButton) findViewById(R.id.radioCelsius);
        rFahrenheit = (RadioButton) findViewById(R.id.radioFahrenreit);
        btnConvert = (Button) findViewById(R.id.btnConvert);
    }

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText = findViewById(R.id.inputTemperatura);
                inputStr = editText.getText().toString();

                if (!TextUtils.isEmpty(inputStr)) {

                    temperature = Double.valueOf(inputStr);

                    if (rCelsius.isChecked()) ConverterParaCelsius();
                    else if (rFahrenheit.isChecked()) ConverterParaFahrenheit();

                    else Toast.makeText(MainActivity.this, "Select the measure you want to convert", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "empty, insert a temperature!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ConverterParaCelsius() {
        temperature = (temperature - 32) / 1.8;
        editText.setText(temperature.toString());
        }

    private void ConverterParaFahrenheit() {
        temperature = temperature * 1.8 + 32;
        editText.setText(temperature.toString());
    }
}



