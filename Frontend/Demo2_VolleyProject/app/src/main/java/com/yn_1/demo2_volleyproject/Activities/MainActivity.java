package com.yn_1.demo2_volleyproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yn_1.demo2_volleyproject.Book;
import com.yn_1.demo2_volleyproject.Const;
import com.yn_1.demo2_volleyproject.R;
import com.yn_1.demo2_volleyproject.VolleyCommand;
import com.yn_1.demo2_volleyproject.VolleyRequests.StringRequester;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Book search objects
    EditText stringInput;
    Button submitSearchButton;
    String searchedTitle;
    TextView selectedBook;
    TextView showSearched;

    //Collection of books
    ArrayList<Book> library = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateLibrary();

        //Book search
        stringInput = (EditText) findViewById(R.id.searchBookTitle);
        stringInput.setHint("Input book title...");
        showSearched = (TextView) findViewById(R.id.showSearched);
        selectedBook = (TextView) findViewById(R.id.selectedBook);
        submitSearchButton = (Button) findViewById(R.id.submitSearch);
        submitSearchButton.setText("Submit");
        submitSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchedTitle = stringInput.getText().toString();
                showSearched.setText("Searched for " + searchedTitle + "!");
                Book searchedBook = searchLibrary(searchedTitle);
                if (searchedBook != null) {
                    String text = searchedBook.toString() + " found in library!";
                    selectedBook.setText(text);
                }
                else {
                    selectedBook.setText(searchedTitle + " not found in library.");
                }
            }
        });

    }

    /**
     * Populates the library with some books
     */
    private void populateLibrary() {

        library.add(new Book("Roba's Autobiography", "Roba", 2022, "3", 9000));
        library.add(new Book("Life of Kevin", "Kyle", 2022, "7", 2.2));
        library.add(new Book("Life of Kyle", "Other Kyle", 2022, "number", 4.3));

    }

    /**
     * Searches for a book in the library
     * @param title is the title of the book to search for
     * @return a book if one is found or null is not
     */
    private Book searchLibrary(String title) {

        StringRequester titleRequester = new StringRequester();
        StringCommand command = new StringCommand();
        //todo: give it the correct URL (not yet implemented because URL is not yet ready)
        titleRequester.postRequest("url", title, command, null, null);
        if (command.string != null) {
            return new Book(command.string);
        }
        else {
            return null;
        }

    }

    private class StringCommand implements VolleyCommand<String> {

        String string = null;

        @Override
        public void execute(String data) {
            this.string = data;
        }

    }

}