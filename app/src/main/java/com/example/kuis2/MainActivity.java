package com.example.transactionapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtBalance;
    private ListView listView;
    private TransactionAdapter adapter;
    private ArrayList<Transaction> transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBalance = findViewById(R.id.txtBalance);
        listView = findViewById(R.id.listView);
        Button btnAdd = findViewById(R.id.btnAdd);

        transactions = TransactionRepository.getInstance().getTransactions();
        adapter = new TransactionAdapter(this, transactions);
        listView.setAdapter(adapter);

        updateBalance();

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TambahActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        updateBalance();
    }

    private void updateBalance() {
        int balance = 0;
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                balance -= t.getAmount();
            } else {
                balance += t.getAmount();
            }
        }
        txtBalance.setText("Rp. " + balance);
    }
}
