package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yn_1.demo2_volleyproject.R;

public class MainActivity extends AppCompatActivity {

    TextView showSearched;
    String searched;
    EditText stringInput;
    Button submitSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringInput = (EditText) findViewById(R.id.searchBookTitle);
        stringInput.setHint("Input book title...");
        showSearched = (TextView) findViewById(R.id.showSearched);
        submitSearchButton = (Button) findViewById(R.id.submitSearch);
        submitSearchButton.setText("Submit");
        submitSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searched = stringInput.getText().toString();
                showSearched.setText("Searched for " + searched + "!");
            }
        });

    }

}