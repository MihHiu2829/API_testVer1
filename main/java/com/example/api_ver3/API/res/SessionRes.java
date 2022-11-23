package com.example.api_ver3.API.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SessionRes implements Serializable {
    @SerializedName("success")
    public boolean success ;
    @SerializedName("session_id")
    public String sessionId ;


    @Override
    public String toString() {
        return "SessionRes{" +
                "success=" + success +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
