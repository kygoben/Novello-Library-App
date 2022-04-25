package com.yn_1.novello_app.chat.privateChat;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.chat.Chat;
import com.yn_1.novello_app.chat.ChatFragment;
import com.yn_1.novello_app.chat.ChatFragmentDirections;
import com.yn_1.novello_app.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A fragment representing a list of Items.
 */
public class PrivateChatFragment extends Fragment implements PrivateChatContract.View, PrivateChatContract.ViewListener {

    private PrivateChatContract.Presenter presenter;

    private static final String ARG_PRIVATE_CHATS = "private-chats";
    private static final String ARG_CURRENT_USER = "current-user";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PrivateChatFragment() {
    }

    public static PrivateChatFragment newInstance(List<Chat> privateChats) {
        PrivateChatFragment fragment = new PrivateChatFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PRIVATE_CHATS, (ArrayList<? extends Parcelable>) privateChats);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            List<Chat> privateChats = getArguments().getParcelableArrayList(ARG_PRIVATE_CHATS);
            User currentUser = getArguments().getParcelable(ARG_CURRENT_USER);
            presenter = new PrivateChatPresenter(
                    new PrivateChatModel(currentUser, privateChats), this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_private_chat_list, container, false);
        return view;
    }

    @Override
    public void displayChatList(List<Chat> items1, Map<Integer, Bitmap> items2) {
        View view = getView();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new PrivateChatRecyclerViewAdapter(items1, items2,
                    ((NavBarActivity)getActivity()).getUser(), this));
        }
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    @Override
    public void navigateToMessageView(int id) {
        ChatFragmentDirections.ActionChatFragmentToMessageFragment action =
                ChatFragmentDirections.actionChatFragmentToMessageFragment
                        ((getArguments().getParcelable(ARG_CURRENT_USER)),
                                presenter.transferChatsToView().get(id));
        ((NavBarActivity) ((ChatFragment) getHost()).getActivity()).getController()
                .navigate(action);
    }
}