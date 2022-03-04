package com.yn_1.demo2_volleyproject.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.JsonObjectRequest;
import com.yn_1.demo2_volleyproject.R;

/**
 * Activity for logging in. Start screen upon opening app.
 */
public class LoginActivity extends AppCompatActivity {

    EditText usernameInputView;
    EditText passwordInputView;
    Button login;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInputView = findViewById(R.id.inputUsername);
        passwordInputView = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        createAccount = findViewById(R.id.createAccount);

        login.setOnClickListener(v -> {
            String username = usernameInputView.getText().toString();
            String password = passwordInputView.getText().toString();
            //todo: correct URL in next line
            //todo: setup next line as we determine we should
            //userRequester.getRequest("getUser", accountCredentialsJson, command, null, null)
        });

        createAccount.setOnClickListener(v -> {
            //todo: go to create account activity
        });

    }

}
