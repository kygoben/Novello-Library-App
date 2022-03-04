package com.yn_1.demo2_volleyproject.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.yn_1.demo2_volleyproject.R;

/**
 * Activity for logging in. Start screen upon opening app.
 */
public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        createAccount = findViewById(R.id.createAccount);

    }

}
