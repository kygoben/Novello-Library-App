package com.yn_1.novello_app.library;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.LinearLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import com.yn_1.novello_app.account.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryPresenter implements LibraryContract.Presenter {

    private LibraryContract.Model model;
    private LibraryContract.View view;

    private List<ImageButton> bookButtons;

    public LibraryPresenter(LibraryContract.Model model, LibraryContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void beforeViewCreated(User user) {
        Log.d("Presenter", "beforeViewCreated() called");
        model.fetchAllBooks(user, view, this);
    }

    @Override
    public void onViewCreated(User user, Context context) {
        view.displayAllBooks(model.getUserBookCollection());
    }

    @Override
    public void onBookTapped(Book book) {
        view.displayBook(book);
    }

    // TODO: On book held, allow user to remove book or rate book in user collection
    @Override
    public void onBookHeld(Book book) { }

    @Override
    public void createBookButtons(Context context) {
        bookButtons = new ArrayList<>();
        Log.d("Library", "Book collection size " + model.getUserBookCollection().size());
        for (Book book : model.getUserBookCollection()) {
            ImageButton button = new ImageButton(context);

            LayoutParams params = new LayoutParams(175,
                    HorizontalScrollView.LayoutParams.MATCH_PARENT);
            params.setMargins(5, 0, 5, 0);
            button.setLayoutParams(params);
            button.setBackgroundColor(Color.YELLOW);

            model.assignImageToBook(book.getImageURL(), button, view);

            button.setOnClickListener(v -> {
                onBookTapped(book);
            });
            button.setOnLongClickListener(null); //TODO: Hold to show dialog to remove, rate, etc.

            bookButtons.add(button);
            book.setImageButton(button);
        }
    }

    @Override
    public List<ImageButton> getBookButtons() {
        return bookButtons;
    }
}
