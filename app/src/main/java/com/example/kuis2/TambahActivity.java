package app.src.main.java.com.example.kuis2;

package com.example.kuis2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {

    private EditText edtDate, edtAmount, edtDescription;
    private RadioButton rbIncome, rbExpense;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edtDate = findViewById(R.id.edtDate);
        edtAmount = findViewById(R.id.edtAmount);
        edtDescription = findViewById(R.id.edtDescription);
        rbIncome = findViewById(R.id.rbIncome);
        rbExpense = findViewById(R.id.rbExpense);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String date = edtDate.getText().toString();
            String amountString = edtAmount.getText().toString();
            String description = edtDescription.getText().toString();
            boolean isExpense = rbExpense.isChecked();

            try {
                int amount = Integer.parseInt(amountString);
                Transaction transaction = new Transaction(date, amount, description, isExpense);
                TransactionRepository.getInstance().addTransaction(transaction);
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Harap masukkan jumlah yang valid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
