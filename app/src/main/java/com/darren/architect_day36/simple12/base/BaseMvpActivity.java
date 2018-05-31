package com.darren.architect_day36.simple12.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.darren.architect_day36.simple12.proxy.ActivityMvpProxy;
import com.darren.architect_day36.simple12.proxy.ActivityMvpProxyImpl;

/**
 * Description:
 * Data：1/23/2018-2:16 PM
 *
 * @author: yanzhiwen
 */
public abstract class BaseMvpActivity extends AppCompatActivity implements BaseView {
    private ActivityMvpProxy mActivityMvpProxy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivityMvpProxy = createActivityMvpProxy();
        mActivityMvpProxy.bindAndCreatePresenter();
        initView();
        initData();
    }

    protected ActivityMvpProxy createActivityMvpProxy() {
        if (mActivityMvpProxy == null) {
            mActivityMvpProxy = new ActivityMvpProxyImpl<>(this);
        }
        return mActivityMvpProxy;
    }


    //由子类去创建
//    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityMvpProxy.unbindPresenter();
    }
}
