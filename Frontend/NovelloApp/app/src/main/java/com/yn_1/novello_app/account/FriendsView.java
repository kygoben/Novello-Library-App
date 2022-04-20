package com.yn_1.novello_app.account;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.home.HomeFragmentDirections;

/**
 * Friends screen view
 */
public class FriendsView extends Fragment {

    String[] friendsArray;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        friendsArray = FriendsViewArgs.fromBundle(getArguments()).getFriendsArray();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_view, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showFriends();

    }

    private void showFriends() {

        //todo: friends view not entered via profile friends view button which is executing in full: need to add navigation in nav bar activity
        //todo: show friends (usernames) in list view

    }

}