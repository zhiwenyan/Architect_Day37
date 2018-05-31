package com.darren.architect_day36.simple7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.darren.architect_day36.R;
import com.darren.architect_day36.retrofit.UserInfo;

public class Main7Activity extends AppCompatActivity implements UserInfoContract.UserInfoView {
    private UserInfoPresenter mPresenter;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        mTextView=(TextView) findViewById(R.id.textView);
        mPresenter = new UserInfoPresenter();
        mPresenter.attach(this);
        //调用Presenter方法
        //这是一个耗时操作
        mPresenter.getUsers("5daefee2ce7f9208d465fab4ae6e40c2");
    }

    @Override
    public void onLoading() {
        //加载进度条
    }

    @Override
    public void onError() {
        //显示错误
    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        //显示成功
        //成功 这个时候可能会关闭Activity，有可能会异常崩溃
        //1、判读界面还在不在  有么有被finish掉
        //2、采用解绑（通用）
        mTextView.setText(userInfo.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
