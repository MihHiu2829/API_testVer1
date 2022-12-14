package com.example.api_ver3.View.FRG;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.api_ver3.ViewModel.OnAPICallBack;
import com.example.api_ver3.ViewModel.baseViewModel;
import com.example.api_ver3.databinding.M001LoginBinding;
import com.example.api_ver3.onMainCallBack;

public abstract class base_FRG <M extends ViewBinding, T extends baseViewModel>
        extends Fragment implements OnAPICallBack {

    M binding;
    T viewModel;
    Context context;
    onMainCallBack callBack;
    Object data;


    public void setData(Object data) {
        this.data = data;
    }

    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewModel = new ViewModelProvider(this).get(ClassVM());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot();
    }

    protected abstract void initViews();

    protected abstract Class<T> ClassVM();

    protected abstract M initViewBinding(LayoutInflater inflater, ViewGroup container);


    @Override
    public void apiSuccess(String key, Object data) {

    }

    @Override
    public void apiError(String key, int code, Object data) {
        if(code == 401)
            callBack.showFragment(m001_login.class.getName(), null , false);
        else
            Toast.makeText(context, "Error: " + code, Toast.LENGTH_SHORT).show();
    }
}
