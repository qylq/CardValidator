package com.qylex.cardvalidator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numberInput;
    private Button validate;
    private TextView validationResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.CardNumberInput);
        validate = findViewById(R.id.ValidateCardNumber);
        validationResult = findViewById(R.id.NumberValidationResult);
    }

    public void check(View v) {
        String cardNumber = numberInput.getText().toString();
        if (cardNumber.length() != 16) {
            validationResult.setText("Card number must be 16 digits long");
            return;
        }

        int[] digitsFromNumber = new int[16];
        for (int i = 0; i < 16; i++) {
            digitsFromNumber[i] = Character.getNumericValue(cardNumber.charAt(i));
        }

        int sum = 0;

        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                digitsFromNumber[i] *= 2;
                if (digitsFromNumber[i] > 9) {
                    digitsFromNumber[i] -= 9;
                }
            }
            sum += digitsFromNumber[i];
        }

        if (sum % 10 == 0) {
            validationResult.setText("Card number is valid!");
        } else {
            validationResult.setText("Card number is not valid");
        }
    }
}