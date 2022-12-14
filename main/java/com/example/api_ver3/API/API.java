package com.example.api_ver3.API;

import com.example.api_ver3.API.req.AccountReq;
import com.example.api_ver3.API.req.RequesTokenReq;
import com.example.api_ver3.API.res.AuthenRes;
import com.example.api_ver3.API.res.SessionRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    String  API_KEY = "adee871a78e5736c792ff131a3a29566" ;

    @GET("authentication/token/new?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> getAuthen();


    @POST("authentication/token/validate_with_login?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> createSession(@Body AccountReq acc);


    @POST("authentication/session/new?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<SessionRes> createSessionID(@Body RequesTokenReq tokenReq);


//    @POST("authentication/token/lidate_with_login?api_key=" + API_KEY)
//    Call<AccountReq>

}
