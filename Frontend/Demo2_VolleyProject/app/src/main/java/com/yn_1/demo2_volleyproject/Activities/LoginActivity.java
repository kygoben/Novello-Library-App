package com.yn_1.demo2_volleyproject.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonObjectRequester;

import org.json.JSONException;
import org.json.JSONObject;

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
            JsonObjectRequester userRequester = new JsonObjectRequester();
            JsonObjectCommand command = new JsonObjectCommand();
            String username = usernameInputView.getText().toString();
            String password = passwordInputView.getText().toString();
            JSONObject accountCredentialsJson = new JSONObject();
            try {
                accountCredentialsJson.put("username", username);
                accountCredentialsJson.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //todo: correct URL in next line
            userRequester.getRequest("getUser", accountCredentialsJson, command, null, null);
        });

        createAccount.setOnClickListener(v -> {
            //todo: go to create account activity
        });

    }

    /**
     * Moves to starting screen after login (dashboard)
     * @param loginSucceeded is true if the login information matches an existing user
     */
    private void loginResult(boolean loginSucceeded) {

        //todo: go to dashboard once dashboard is created
        String text;
        if (loginSucceeded) {
            text = "Login succeeded! Pretend like this went to the dashboard like it's supposed to!";
        }
        else {
            text = "Login failed. Try again!";
        }
        login.setText(text);

    }

    /**
     * Class used to get result of request
     */
    private class JsonObjectCommand implements VolleyCommand<JSONObject> {

        @Override
        public void execute(JSONObject data) {
            loginResult(data != null);
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}
