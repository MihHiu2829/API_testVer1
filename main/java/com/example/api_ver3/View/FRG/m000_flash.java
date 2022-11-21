package com.example.api_ver3.View.FRG;

import android.os.Handler;
import android.preference.DialogPreference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.api_ver3.ViewModel.CommonVM;
import com.example.api_ver3.databinding.M000FlashBinding;

public class m000_flash extends base_FRG<M000FlashBinding, CommonVM> {
    @Override
    protected void initViews() {
        Log.i(m000_flash.class.getName(), "Initviews.... ") ;
        new Handler().postDelayed(() -> callBack.showFragment(m001_login.class.getName(),null,false),1000);
    }

    @Override
    protected Class<CommonVM> ClassVM() {
        return CommonVM.class;
    }

    @Override
    protected M000FlashBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M000FlashBinding.inflate(inflater,container,false);
    }


}
