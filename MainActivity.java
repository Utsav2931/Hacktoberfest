package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText phone;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.editTextTextPassword);
    }

    public void confirm_reg(View view) {
        if(check_phone() && password()) {
            Toast.makeText(MainActivity.this,"Your response has been recorded",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean check_phone() {
        String phoneno = phone.getText().toString();
        if(phoneno.isEmpty()) {
        phone.requestFocus();
        phone.setError("Field can't be empty");
        return false;
        } else if(!Patterns.PHONE.matcher(phoneno).matches()) {
            phone.requestFocus();
            phone.setError("Enter Valid Phone no.");
            return false;
        }
        return  true;
    }
    public boolean password() {
        String passd = password.getText().toString();
        if(passd.isEmpty()) {
            password.requestFocus();
            password.setError("Field can't be empty");
            return false;
        } else if(passd.length() < 6) {
            password.requestFocus();
            password.setError("Password to small");
            return false;
        } return true;
    }
}