package com.example.wordcounteroldsch;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinnerMetrics;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        spinnerMetrics = findViewById(R.id.spinnerMetrics);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        String[] options = {"Words", "Characters"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinnerMetrics.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = txtInput.getText().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_empty_warning, Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedOption = spinnerMetrics.getSelectedItem().toString();
                int result = 0;

                if (selectedOption.equals("Words")) {
                    result = TextMetricsCounter.getWordsCount(inputText);
                } else {
                    result = TextMetricsCounter.getCharsCount(inputText);
                }

                tvResult.setText(getString(R.string.default_result_text) + " " + result);
            }
        });
    }
}