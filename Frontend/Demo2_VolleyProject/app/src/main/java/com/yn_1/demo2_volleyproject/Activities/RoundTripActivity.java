package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.yn_1.demo2_volleyproject.Book;
import com.yn_1.demo2_volleyproject.Const;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequesters.JsonObjectRequester;

import org.json.JSONException;
import org.json.JSONObject;

public class RoundTripActivity extends AppCompatActivity {

    //Book search objects
    EditText stringInput;
    Button submitSearchButton;
    String searchedIsbn;
    TextView selectedBook;
    TextView showSearched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateLibrary();

        //Book search
        stringInput = findViewById(R.id.searchBookTitle);
        stringInput.setHint("Input book isbn...");
        showSearched = findViewById(R.id.showSearched);
        selectedBook = findViewById(R.id.selectedBook);
        submitSearchButton = findViewById(R.id.submitSearch);
        submitSearchButton.setText("Submit");
        submitSearchButton.setOnClickListener(v -> {
            searchedIsbn = stringInput.getText().toString();
            showSearched.setText("Searched for " + searchedIsbn + "!");
            searchLibrary(searchedIsbn);
        });

    }

    /**
     * Populates the library with some books
     */
    private void populateLibrary() {

        JsonObjectRequester titleAddRequester = new JsonObjectRequester();
        JsonObjectCommand command = new JsonObjectCommand();
        //to postman
//        titleAddRequester.postRequest("library/0000000000001", null, command, null, null);
        //to backend
        JSONObject bookJson = new JSONObject();
        try {
            bookJson.put("title", "book title 1");
            bookJson.put("isbn", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        titleAddRequester.postRequest("addBooks", bookJson, command, null, null);
    }

    /**
     * Searches for a book in the library
     * @param isbn is the isbn of the book to search for
     * @return a book if one is found or null is not
     */
    private void searchLibrary(String isbn) {

        JsonObjectRequester titleRequester = new JsonObjectRequester();
        JsonObjectCommand command = new JsonObjectCommand();
        //to postman
//        titleRequester.getRequest("library/books/" + isbn, null, command, null, null);
        //to backend
        JSONObject bookJson = new JSONObject();
        try {
            bookJson.put("isbn", isbn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //post isbn search being ready
//        titleRequester.getRequest("book", bookJson, command, null, null);
        //pre isbn search being ready: id search
        titleRequester.getRequest( "book/1", bookJson, command, null, null);

    }

    /**
     * Changes text depending on whether book found or not
     * @param command is the result of the get request
     */
    private void searchResult(JsonObjectCommand command) {

        Book book = null;
        if (command.title != null) {
            book = new Book(command.title);
        }
        if (book != null) {
            String text = book.getTitle() + " found in library!";
            selectedBook.setText(text);
        }
        else {
            selectedBook.setText(Const.postmanMockUrl + "isbn: " + searchedIsbn + " not found in library.");
        }

    }

    /**
     *
     * @param rating
     * @author Roba Abbajabal
     */
    private void changeBookRating(int rating) {
        JSONObject bookToRate = new JSONObject();
        try {
            bookToRate.put("rating", rating);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequester requester = new JsonObjectRequester();
        requester.putRequest("books", bookToRate, new VolleyCommand<JSONObject>() {
            @Override
            public void execute(JSONObject data) { }

            @Override
            public void onError(VolleyError error) {
                Log.e(requester.TAG, "Error on delete: Book not found.");
            }
        }, null, null);
    }

    /**
     * Class used to get result of request
     */
    private class JsonObjectCommand implements VolleyCommand<JSONObject> {

        String title = null;

        @Override
        public void execute(JSONObject data) {
            try {
                title = data.getString("title");
                searchResult(this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}