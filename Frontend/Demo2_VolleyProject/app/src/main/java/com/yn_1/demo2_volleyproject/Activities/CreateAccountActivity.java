package com.yn_1.demo2_volleyproject.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.yn_1.demo2_volleyproject.NullCommand;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonObjectRequester;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Activity for creating an account. Reachable only through the login activity.
 */
public class CreateAccountActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    EditText usernameInput;
    EditText passwordInput;
    EditText passwordConfirmInput;
    Button createAccount;
    TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        constraintLayout = findViewById(R.id.constraintLayout);
        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        passwordConfirmInput = findViewById(R.id.confirmPassword);
        createAccount = findViewById(R.id.createAccount);

        createAccount.setOnClickListener(v -> {
            JsonObjectRequester userAddRequester = new JsonObjectRequester();
            NullCommand command = new NullCommand();
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            String passwordConfirmation = passwordConfirmInput.getText().toString();
            if (password.equals(passwordConfirmation)) {
                JSONObject userJson = new JSONObject();
                try {
                    userJson.put("username", username);
                    userJson.put("password", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //todo: correct URL in next line
                userAddRequester.postRequest("addUser", userJson, command, null, null);
            }
            else {
                warning = findViewById(R.id.warning);
                warning.setText("Passwords do not match!");
                warning.setBackgroundColor(Color.RED);
            }
        });

    }

}
