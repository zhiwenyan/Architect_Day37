package com.darren.architect_day36.simple2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.darren.architect_day36.R;
import com.darren.architect_day36.retrofit.UserInfo;


public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView{
    private TextView mUserInfoTv;
    private UserInfoContract.UserInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // OkHttp +RxJava + Retrofit 这样写代码行不行？ 1 ，2 ，
        mUserInfoTv = (TextView) findViewById(R.id.user_info_tv);

        // 调用 Presenter 的方法
        mPresenter = new UserInfoPresenter(this);
        // 耗时操作
        mPresenter.getUsers("ed6b0f7f34dd8cf7b003e40691457175");
    }

    @Override
    public void onLoading() {
        // 加载进度条
    }

    @Override
    public void onError() {
        // 显示错误
    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        // 成功 这个时候 Activity 有可能会被关闭掉，有可能会异常崩溃（一般不会）
        // 1. 可以判断界面还在不在(试一试)
        // 2. 采用解绑（通用）
        mUserInfoTv.setText(userInfo.toString());
    }
}
