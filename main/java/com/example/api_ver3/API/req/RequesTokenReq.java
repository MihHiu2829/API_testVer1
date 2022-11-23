package com.example.api_ver3.API.req;

import com.google.gson.annotations.SerializedName;

public class RequesTokenReq {
    @SerializedName("request_Token")
    public String requesttoken ;

    public RequesTokenReq(String requesttoken) {
        this.requesttoken = requesttoken;
    }
}
