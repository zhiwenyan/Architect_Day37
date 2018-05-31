package com.darren.architect_day36.simple8.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:
 * Data：1/23/2018-2:16 PM
 *
 * @author: yanzhiwen
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //创建P，创建交给子类
        mPresenter = createPresenter();
        //绑定View
        mPresenter.attach(this);
        initView();
        initData();
    }

    //由子类去创建
    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    public P getPresenter() {
        return mPresenter;
    }
}
