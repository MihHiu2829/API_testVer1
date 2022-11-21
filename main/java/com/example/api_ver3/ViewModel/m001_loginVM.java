package com.example.api_ver3.ViewModel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.api_ver3.API.API;
import com.example.api_ver3.API.req.AccountReq;
import com.example.api_ver3.API.res.AuthenRes;
import com.example.api_ver3.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class m001_loginVM extends baseViewModel{
    private static final String BASE_URL = "https://api.themoviedb.org/3/" ;
    private static final String TAG = m001_loginVM.class.getName() ;
    public String password ;
    public String username ;


    public void getAutehn(String un, String pw)
    {
        password = pw ;
        username = un ;
        Retrofit rs = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build()).build();
         API api = rs.create(API.class) ;
//        api.getAuthen().enqueue(new Callback<AuthenRes>() {
//            @Override
//            public void onResponse(@Nullable Call<AuthenRes> call, @Nullable Response<AuthenRes> response) {
//
//                if(response.code() == 200 || response.code() == 201)
//                {
//                    handleSuccess(response.body());
//                }else{
//                    handleFail(response);
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(@Nullable Call<AuthenRes> call,@Nullable Throwable t) {
//                Log.e(TAG, "onFailure:  "+ t.getMessage()) ;
//
//            }
//        });
        api.getAuthen().enqueue(new Callback<AuthenRes>() {
            @Override
            public void onResponse(@Nullable  Call<AuthenRes> call,@Nullable Response<AuthenRes> response) {
                        if(response.code() == 200 || response.code() == 201)
                                handleSuccess(response.body());
                        else handleFail(response);
            }

            @Override
            public void onFailure(@Nullable Call<AuthenRes> call, @Nullable Throwable t) {
                Log.e(TAG,"onFailure: "+ t.getMessage()) ;
            }
        });
    }

    private void handleFail(Response<AuthenRes> response) {
        Log.e(TAG, "handleFail:  "+ response.code()) ;

    }

    private void handleSuccess(AuthenRes body) {
        Log.e(TAG, "handleSuccess:  "+ body) ;
        createSession(body.requestToken,username,password);
    }

    private void createSession(String requestToken, String username, String password)
    {
        Retrofit rs = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build()).build();
        API api = rs.create(API.class) ;
        api.createSession(new AccountReq(username,password,requestToken)).enqueue(new Callback<AuthenRes>() {
            @Override
            public void onResponse(@Nullable Call<AuthenRes> call, @Nullable Response<AuthenRes> response) {

                if(response.code() == 200 || response.code() == 201)
                {
                    handleSuccess(response.body());
                }els    e{

                    handleFail(response);
                }
            }
            @Override
            public void onFailure(@Nullable Call<AuthenRes> call,@Nullable Throwable t) {
                Log.e(TAG, "onFailure :  "+ t.getMessage()) ;
            }
        });
    }
}
