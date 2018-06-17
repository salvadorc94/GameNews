package com.example.salvador.gamenews.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {
    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }
}
