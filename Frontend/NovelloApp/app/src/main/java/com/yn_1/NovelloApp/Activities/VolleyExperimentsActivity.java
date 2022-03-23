package com.yn_1.NovelloApp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.yn_1.NovelloApp.R;
import com.yn_1.NovelloApp.VolleyCommand;
import com.yn_1.NovelloApp.VolleyRequesters.ImageRequester;
import com.yn_1.NovelloApp.VolleyRequesters.JsonArrayRequester;
import com.yn_1.NovelloApp.VolleyRequesters.JsonObjectRequester;

import org.json.JSONArray;
import org.json.JSONObject;

public class VolleyExperimentsActivity extends AppCompatActivity {

    public static TextView testView;
    public static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_experiments);

        testView = findViewById(R.id.testView);
        testView.setText("Loading...");
        imageView = findViewById(R.id.imageView2);


        JsonArrayRequester requester = new JsonArrayRequester();
        JsonArrayTestCommand jsonArrayTestCommand = new JsonArrayTestCommand();
        requester.getRequest("https://api.androidhive.info/volley/person_array.json", null, jsonArrayTestCommand, null, null);

        ImageRequester requester2 = new ImageRequester();
        ImageTestCommand imageTestCommand = new ImageTestCommand();
        requester2.getRequest("https://api.androidhive.info/volley/volley-image.jpg", null, imageTestCommand, null, null);

        JsonObjectRequester requester3 = new JsonObjectRequester();
        JSONObjectTestCommand jsonObjectTestCommand = new JSONObjectTestCommand();
        requester3.getRequest("https://06817084-8904-405a-8e1b-2c60a3fae2a2.mock.pstmn.io/library/?userID=1&email=robaa@iastate.edu&bookTitle=The%20Brothers%20Karamazov",
                null, jsonObjectTestCommand, null, null);
    }

    class JsonArrayTestCommand implements VolleyCommand<JSONArray> {
        @Override
        public void execute(JSONArray data) {
            testView.setText(data.toString());
        }

        @Override
        public void onError(VolleyError error) {
            testView.setText(error.getMessage());
        }
    }

    class ImageTestCommand implements VolleyCommand<Bitmap> {
        @Override
        public void execute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }

        @Override
        public void onError(VolleyError error) {
        }
    }

    class JSONObjectTestCommand implements VolleyCommand<JSONObject> {
        @Override
        public void execute(JSONObject data) {
            testView.setText(data.toString());
        }

        @Override
        public void onError(VolleyError error) {
            testView.setText(error.getMessage());
        }
    }
}