package com.darren.architect_day36.simple10;

import android.widget.TextView;

import com.darren.architect_day36.R;
import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple10.Base.BaseMvpActivity;

public class Main10Activity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {
    private TextView mTextView;
    //多个Presenter怎么处理 dagger处理，自己写dagger处理 自己写个注入

    @Override
    protected UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initView() {
        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    protected void initData() {
        getPresenter().getUsers("ed6b0f7f34dd8cf7b003e40691457175");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main6;
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
}
