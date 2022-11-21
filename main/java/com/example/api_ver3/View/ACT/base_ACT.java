package com.example.api_ver3.View.ACT;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.api_ver3.View.FRG.base_FRG;
import com.example.api_ver3.onMainCallBack;

import java.lang.reflect.Constructor;

public abstract class base_ACT <M extends ViewBinding,T extends ViewModel>
        extends AppCompatActivity implements onMainCallBack {

    M binding ;
    T viewModel ;


    @Override
    public void showFragment(String TAG, Object data, boolean isBack) {
        try{
            Class<?> clazz = Class.forName(TAG) ;
            Constructor<?> cons =  clazz.getConstructor()  ;
            base_FRG<?,?> frg = (base_FRG<?, ?>) cons.newInstance();
            frg.setCallBack(this);
            frg.setData(data);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction() ;
            if(isBack)
                trans.addToBackStack(null) ;
            trans.replace(getIDmain(),frg,TAG).commit() ;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected abstract int getIDmain();


    @Override
    public void backToPrevious() {
        onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        viewModel = new ViewModelProvider(this).get(ClassVM());
        initViews()   ;
        setContentView(binding.getRoot());
    }

    protected abstract void initViews();

    protected abstract Class<T> ClassVM();

    protected abstract M initViewBinding();
}
