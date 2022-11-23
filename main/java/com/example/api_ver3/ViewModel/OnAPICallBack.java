package com.example.api_ver3.ViewModel;

public interface OnAPICallBack {
    void apiSuccess(String key, Object data) ;
    void apiError(String key, int code,Object data);
}
