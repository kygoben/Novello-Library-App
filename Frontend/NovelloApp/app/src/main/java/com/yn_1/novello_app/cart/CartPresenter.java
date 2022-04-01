package com.yn_1.novello_app.cart;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart screen presenter
 */
public class CartPresenter {

    CartView view;
    CartModel model;

    User user = null;

    /**
     * Constructor. Creates model.
     */
    public CartPresenter(CartView view) {
        this.view = view;
        model = new CartModel(this);
    }

    /**
     * @return books in cart
     */
    public void getCartBooks() {
        model.getCartBooks();
    }

    public void sendCart(ArrayList<Book> cart) {
        view.sendCart(cart);
    }

    /**
     * Sets user for Presenter and Model
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        model.setUser(user);
    }

    /**
     * Purchase clicked
     * @param cartView
     */
    public void purchaseClicked(CartView cartView) {
        openPurchase(cartView);
    }

    /**
     * Goes to purchase screen
     * @param cartView
     */
    public void openPurchase(CartView cartView) {
        //todo: test leave cart through pay screens
        Fragment libraryFragment = LibraryFragment.newInstance();
        cartView.getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                libraryFragment).addToBackStack(null).commit();
    }

}