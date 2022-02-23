package com.yn_1.demo2_volleyproject.VolleyRequests;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yn_1.demo2_volleyproject.AppController;
import com.yn_1.demo2_volleyproject.VolleyCommand;

import org.json.JSONObject;

import java.util.Map;

/**
 * Volley JSON object request class.
 *
 * @author Maxim Popov
 */
public class JsonObjectRequester implements Requester<JSONObject> {

    // Request tag for debugging.
    public static final String TAG="json_array_req";

    @Override
    public void getRequest(String url, VolleyCommand command,
                                 Map<String, String> headers, Map<String, String> params) {
        JsonObjectRequest getJsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(getJsonArrayRequest, TAG);
    }

    @Override
    public void postRequest(String url, JSONObject post, VolleyCommand command,
                            Map<String, String> headers, Map<String, String> params) {
        JsonObjectRequest postJsonArrayRequest = new JsonObjectRequest(
                Request.Method.POST, url, post,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(postJsonArrayRequest, TAG);
    }

    @Override
    public void putRequest(String url, JSONObject put, VolleyCommand command,
                           Map<String, String> headers, Map<String, String> params) {
        JsonObjectRequest putJsonArrayRequest = new JsonObjectRequest(
                Request.Method.PUT, url, put,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(putJsonArrayRequest, TAG);
    }

    @Override
    public void deleteRequest(String url, VolleyCommand command,
                              Map<String, String> headers, Map<String, String> params) {
        JsonObjectRequest deleteJsonArrayRequest = new JsonObjectRequest(
                Request.Method.DELETE, url, null,
                response -> {
                    Log.d(TAG, response.toString());
                    command.execute(response);
                }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (headers == null)
                    return super.getParams();
                else
                    return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(deleteJsonArrayRequest, TAG);
    }

}
