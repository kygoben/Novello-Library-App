package com.yn_1.novello_app.discovery;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Model for the discovery screen
 */
public class DiscoveryModel {

    DiscoveryPresenter presenter;

    int userID;

    /**
     * Constructor
     * @param presenter
     */
    public DiscoveryModel (DiscoveryPresenter presenter, int userID) {
        this.presenter = presenter;
        this.userID = userID;
    }

    /**
     * Gets all books to run recommendation algorithm over
     */
    public void getAllBooks() {

        JsonArrayRequester allBooksRequester = new JsonArrayRequester();
        JsonArrayCommandAllBooks command = new JsonArrayCommandAllBooks();
        allBooksRequester.getRequest("book", null, command, null, null);

    }

    public void getUserBooks() {

        JsonArrayRequester userBooksRequester = new JsonArrayRequester();
        JsonArrayCommandUserBooks command = new JsonArrayCommandUserBooks();
        userBooksRequester.getRequest("bookData/user/" + userID, null, command, null, null);

    }

    /**
     * Sends received all books to presenter.
     * @param data
     */
    private void sendAllBooksToPresenter(JSONArray data) {
        ArrayList<Book> allBooks = getBooks(data);
        presenter.sendAllBooks(allBooks);
    }

    /**
     * Sends received user books to presenter.
     * @param data
     */
    private void sendUserBooksToPresenter(JSONArray data) {
        ArrayList<Book> userBooks = getBooks(data);
        presenter.sendUserBooks(userBooks);
    }

    /**
     * Gets books from provided JSOON
     * @param data is a JSON of books
     * @return books
     */
    private ArrayList<Book> getBooks(JSONArray data) {

        ArrayList<Book> userBooks = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            try {
                JSONObject book = data.getJSONObject(i);
                int bookID = book.getInt("bookID");
                String title = book.getString("title");
                String author = book.getString("author");
                String genre = book.getString("genre");
                int publicationYear = book.getInt("publicationYear");
                String isbn = book.getString("isbn");
                int rating = book.getInt("rating");
                int price = book.getInt("msrp");
                String readingUrl = book.getString("readingUrl");
                String imageUrl = book.getString("imageUrl");
                Book newBook = new Book(bookID, title, author, genre, publicationYear, isbn, rating,
                        -1, null, readingUrl, imageUrl);
                userBooks.add(newBook);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return userBooks;

    }

    /**
     * Class used to get result of getAllBooks
     */
    private class JsonArrayCommandAllBooks implements VolleyCommand<JSONArray> {

        @Override
        public void execute(JSONArray data) {
            sendAllBooksToPresenter(data);
        }

        @Override
        public void onError(VolleyError error) { }

    }

    /**
     * Class used to get result of getUserBooks
     */
    private class JsonArrayCommandUserBooks implements VolleyCommand<JSONArray> {

        @Override
        public void execute(JSONArray data) {
            sendUserBooksToPresenter(data);
        }

        @Override
        public void onError(VolleyError error) { }

    }

}
