package com.yn_1.novello_app.cart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PurchaseFragment extends Fragment {

    Button finish;
    EditText creditCardInput;
    String creditCardNumber;
    TextView priceText;
    int userID;
    int[] cartIDs;
    float[] cartPrices;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        userID = PurchaseFragmentArgs.fromBundle(getArguments()).getUserID();
        cartIDs = PurchaseFragmentArgs.fromBundle(getArguments()).getCartIDs();
        cartPrices = PurchaseFragmentArgs.fromBundle(getArguments()).getCartPrices();
        //todo: show list of book titles/authors/prices in vertical scroll view

        double price = 0;
        for (int i = 0; i < cartPrices.length; i++) {
            price += cartPrices[i];
        }
        priceText.setText("Price = $" + price);

        finish.setOnClickListener(v -> {
            creditCardNumber = creditCardInput.getText().toString();
            if (canChargeCard(creditCardNumber)) {
                JsonObjectRequester purchaseRequester = new JsonObjectRequester();
                JsonObjectCommand command = new JsonObjectCommand();
                //todo: 3 represents unread. Set that in an enum.
                for (int i = 0; i < cartIDs.length; i++) {
                    int bookID = cartIDs[i];
                    purchaseRequester.postRequest("setCategory/" + bookID + "/" + userID + "/" + 3,
                            null, command, null, null);
                }
            }
            else {
                //todo: card cannot be charged, do something about it
            }
        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        finish = view.findViewById(R.id.finishPurchase);
        creditCardInput = view.findViewById(R.id.creditCardInput);
        priceText = view.findViewById(R.id.price);

    }

    /**
     * @param creditCardNumber
     * @return true if the card can be charged
     */
    private boolean canChargeCard(String creditCardNumber) {
        //todo: move to user or other more appropriate location
        return true;
    }

    /**
     * @param creditCardNumber
     * @return true if the card was charged successfully
     */
    private boolean chargeCard(String creditCardNumber) {
        //todo: move to user or other more appropriate location
        return true;
    }

    /**
     * Goes to dashboard upon successful purchase completion
     * @param succeeded is true if the purchase was successful
     */
    private void purchaseResult(boolean succeeded) {
        if (chargeCard(creditCardNumber)) {
            ((NavBarActivity)getActivity()).getController().navigate(PurchaseFragmentDirections.
                    actionPurchaseFragmentToHomeFragment());
        }
        else {
            //todo: card could not be charged, do something about it
        }
    }

    /**
     * Class used to get result of request
     */
    private class JsonObjectCommand implements VolleyCommand<JSONObject> {

        @Override
        public void execute(JSONObject data) {
            purchaseResult(data != null);
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}
