package com.yn_1.novello_app.message;

import org.java_websocket.handshake.ServerHandshake;

public class MessagePresenter implements MessageContract.Presenter, MessageContract.WebSocketListener {

    private MessageContract.Model model;
    private MessageContract.View view;

    public MessagePresenter(MessageContract.Model model, MessageContract.View view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void onOpen(ServerHandshake handshake) {

    }

    @Override
    public void onMessage(String message) {

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }
}
