package com.example.api_ver3.ViewModel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.api_ver3.API.API;
import com.example.api_ver3.API.req.AccountReq;
import com.example.api_ver3.API.req.RequesTokenReq;
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
    private static final String TAG = m001_loginVM.class.getName() ;
    private static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    private static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    public static final String KEY_API_CREATE_SESSION_ID = "KEY_API_CREATE_SESSION_ID";

    private String userName, password ;
    public void getAutehn(String un, String pw) {
        this.userName = un ;
        this.password = pw ;

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
        getAPI().getAuthen().enqueue(initHandleResponse(KEY_API_AUTHEN));
    }




    private void createSession(String requestToken) {
        getAPI().createSession(new AccountReq(userName,password,requestToken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSION));
    }
    private void createSessionID(String requestToken) {
        getAPI().createSessionID(new RequesTokenReq(requestToken)).enqueue(initHandleResponse(KEY_API_CREATE_SESSION_ID));
    }

    @Override
    protected void handleSuccess(String key, Object body) {
        Log.e(TAG, "handleSuccess:  "+ body) ;
        if(key.equals(KEY_API_AUTHEN))
        {
            createSession(((AuthenRes)body).requestToken);

        }else if (key.equals(KEY_API_CREATE_SESSION))
        {
            createSessionID(((AuthenRes)body).requestToken);
        }else if(key.equals(KEY_API_CREATE_SESSION_ID))
        {
            callBack.apiSuccess(key,body);
        }
    }
}
