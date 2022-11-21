package com.example.api_ver3.API.req;

import com.google.gson.annotations.SerializedName;

public class AccountReq {
    @SerializedName("username")
    public String username ;
    @SerializedName("password")
    public String password ;
    @SerializedName("request_Token")
    public String requesttoken ;

    public AccountReq(String username, String password, String requesttoken) {
        this.username = username;
        this.password = password;
        this.requesttoken = requesttoken;
    }
}
