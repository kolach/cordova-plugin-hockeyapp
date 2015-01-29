package com.assuredlabor.cordova.hockeyapp;

import java.lang.Override;
import java.lang.RuntimeException;
import org.json.JSONObject;

public class JSException extends RuntimeException {

    private JSONObject data;

    public JSException(String message, JSONObject data) {
        super(message);
    }

    @Override
    public String toString() {
        String result = super.toString();
        if (data != null) {
            result += data.toString();
        }
        return result;
    }

}