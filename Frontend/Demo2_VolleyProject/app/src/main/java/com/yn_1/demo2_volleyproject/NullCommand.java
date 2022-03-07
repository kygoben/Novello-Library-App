package com.yn_1.demo2_volleyproject;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Null command which doesn't do anything. Used when a command is required but no data or actions needed upon return.
 */
public class NullCommand implements VolleyCommand<JSONObject> {

    public NullCommand() {}

    @Override
    public void execute(JSONObject data) {}

    @Override
    public void onError(VolleyError error) {}

}
