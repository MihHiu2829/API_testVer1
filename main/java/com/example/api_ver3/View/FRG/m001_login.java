package com.example.api_ver3.View.FRG;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.api_ver3.ViewModel.m001_loginVM;
import com.example.api_ver3.databinding.M001LoginBinding;

public class m001_login extends base_FRG<M001LoginBinding, m001_loginVM> {
    @Override
    protected void initViews() {

        binding.btLogin.setOnClickListener(v -> viewModel.getAutehn( binding.edtUn.getText().toString() , binding.edtPw.getText().toString()));
    }

    @Override
    protected Class<m001_loginVM> ClassVM() {
        return m001_loginVM.class;
    }


    @Override
    protected M001LoginBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001LoginBinding.inflate(inflater,container,false);
    }
}
