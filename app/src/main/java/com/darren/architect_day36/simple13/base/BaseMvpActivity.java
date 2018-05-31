package com.darren.architect_day36.simple13.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.darren.architect_day36.simple13.proxy.ActivityMvpProxy;
import com.darren.architect_day36.simple13.proxy.ActivityMvpProxyImpl;

/**
 * Created by hcDarren on 2018/1/1.
 */
public abstract class BaseMvpActivity extends AppCompatActivity implements BaseView {
    //    private P mPresenter;
    private ActivityMvpProxy mMvpProxy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();

        mMvpProxy = createMvpProxy();
        mMvpProxy.bindAndCreatePresenter();


        // 1. Activity ？ Fragment? 1,2  ViewGroup ? 抽离  工具类抽出去，或者把代码每个地方 copy 一份
        // 今天你可以抽离目前的一部分：注入代码 + 额外功能 + 还有一些其他地方又不一样
        initView();
        initData();
    }

    /**
     * 创建 Mvp 的代理  自己去写 Fragment
     *
     * @return
     */
    private ActivityMvpProxy createMvpProxy() {
        if (mMvpProxy == null) {
            mMvpProxy = new ActivityMvpProxyImpl<>(this);
        }
        return mMvpProxy;
    }

    // 由子类去实现创建
    //  protected abstract P createPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setContentView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMvpProxy.unbindPresenter();
//        mPresenter.detach();
    }

//    public P getPresenter() {
//        return mPresenter;
//    }
}
