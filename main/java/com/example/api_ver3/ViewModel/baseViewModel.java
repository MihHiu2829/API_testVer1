package com.example.api_ver3.ViewModel;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.example.api_ver3.API.API;
import com.example.api_ver3.API.res.AuthenRes;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class baseViewModel extends ViewModel {
    public static final String BASE_URL = "https://api.themoviedb.org/3/" ;
    protected final String TAG = baseViewModel.class.getName();
    protected OnAPICallBack callBack ;

    public void setCallBack(OnAPICallBack callBack) {
        this.callBack = callBack;
    }

    protected final API getAPI()
    {

        Retrofit rs = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build()).build();
       return rs.create(API.class) ;
    }

    protected  <T>Callback<T> initHandleResponse(String key) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.code() == 200 || response.code() == 201) {
                    assert response.body() != null;
                    handleSuccess(key,response.body());
                }
                else
                    handleFail(key,response.code(),response.errorBody());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage()) ;
                handleException(key,t) ;
            }
        } ;
    }

    protected void handleException(String key, Throwable t) {
        callBack.apiError(key,999,t.getMessage());

    }
    protected void handleFail(String key, int code, ResponseBody responseBody) {
       Log.e(TAG, "handleFail: "+ code) ;
        callBack.apiError(key,999,responseBody);

    }

    protected void handleSuccess(String key, Object body) {
        Log.e(TAG, "handleSuccess:  "+ body) ;
        callBack.apiSuccess(key,body );
    }



}
