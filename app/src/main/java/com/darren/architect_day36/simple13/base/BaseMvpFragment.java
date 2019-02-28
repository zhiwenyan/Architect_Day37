package com.darren.architect_day36.simple13.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.architect_day36.simple13.proxy.FragmentMvpProxy;
import com.darren.architect_day36.simple13.proxy.FragmentMvpProxyImpl;

/**
 * Description:
 * Data：11/26/2018-10:26 AM
 *
 * @author yanzhiwen
 */
public abstract class BaseMvpFragment extends Fragment implements BaseView {
    private FragmentMvpProxy mFragmentMvpProxy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentMvpProxy = createMvpProxy();
        mFragmentMvpProxy.bindAndCreatePresenter();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    /**
     * 创建 Mvp 的代理
     *
     * @return mFragmentMvpProxy
     */
    private FragmentMvpProxy createMvpProxy() {
        if (mFragmentMvpProxy == null) {
            mFragmentMvpProxy = new FragmentMvpProxyImpl<>(this);
        }
        return mFragmentMvpProxy;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentMvpProxy.unbindPresenter();

    }
}
