package com.darren.architect_day36.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.darren.architect_day36.R;
import com.darren.architect_day36.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityUserInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
        final UserViewModel userViewModel = new UserViewModel(binding);
        userViewModel.getUserInfo("000", new HttpCallback<UserInfo>() {
            @Override
            public void onCallBack(UserInfo userInfo) {
                binding.setUser(userInfo);
            }
        });
    }
}
