package com.example.api_ver3.View.ACT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.api_ver3.R;
import com.example.api_ver3.View.FRG.m000_flash;
import com.example.api_ver3.ViewModel.CommonVM;
import com.example.api_ver3.databinding.ActivityMainBinding;

public class MainActivity extends base_ACT<ActivityMainBinding, CommonVM> {

    @Override
    protected int getIDmain() {
        return R.id.Ln_main;
    }

    @Override
    protected void initViews() {
                showFragment(m000_flash.class.getName(),null,false);
    }

    @Override
    protected Class<CommonVM> ClassVM() {
        return CommonVM.class;
    }

    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}