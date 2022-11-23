package com.example.api_ver3.View.FRG;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.api_ver3.API.res.SessionRes;
import com.example.api_ver3.ViewModel.m001_loginVM;
import com.example.api_ver3.databinding.M001LoginBinding;

public class m001_login extends base_FRG<M001LoginBinding, m001_loginVM> {
    @Override
    protected void initViews() {

        binding.btLogin.setOnClickListener(v -> viewModel.getAutehn(binding.edtUn.getText().toString(), binding.edtPw.getText().toString()));
    }

    @Override
    protected Class<m001_loginVM> ClassVM() {
        return m001_loginVM.class;
    }


    @Override
    protected M001LoginBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001LoginBinding.inflate(inflater,container,false);
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if(code == 401)
        {
            Toast.makeText(context, "Tai Khoan dang nhap khong phu hop: "+ code, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(context, "Loi roi ba, ko nhan API ne", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void apiSuccess(String key, Object data) {
        if(key.equals(m001_loginVM.KEY_API_CREATE_SESSION_ID))
        {
            SessionRes res = (SessionRes) data ;
            // save sessionID  to sharepreference
            Toast.makeText(context, "Login is succesful! ", Toast.LENGTH_SHORT).show();
        }
    }
}
