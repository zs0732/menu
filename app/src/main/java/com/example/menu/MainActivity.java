package com.example.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.R;

public class MainActivity extends AppCompatActivity {

    EditText Et1, Et2;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = findViewById(R.id.Et1);
        Et2 = findViewById(R.id.Et2);
        result = findViewById(R.id.result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        try {
            double num1 = Double.parseDouble(Et1.getText().toString());
            double num2 = Double.parseDouble(Et2.getText().toString());
            double res;

            if (id == R.id.menu_add) {
                res = num1 + num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_subtract) {
                res = num1 - num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_multiply) {
                res = num1 * num2;
                result.setText("תוצאה: " + res);
            } else if (id == R.id.menu_divide) {
                if (num2 != 0) {
                    res = num1 / num2;
                    result.setText("תוצאה: " + res);
                } else {
                    Toast.makeText(this, "אי אפשר לחלק ב-0", Toast.LENGTH_SHORT).show();
                }
            } else if (id == R.id.menu_clear) {
                Et1.setText("");
                Et2.setText("");
                result.setText("תוצאה: ");
            }
            return true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "אנא הזן מספרים תקינים", Toast.LENGTH_SHORT).show();
            return false;
        }
}
    }