package com.darren.architect_day36.simple12.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.architect_day36.simple12.proxy.FragmentMvpProxy;
import com.darren.architect_day36.simple12.proxy.FragmentMvpProxyImpl;

/**
 * Description:
 * Data：3/23/2018-11:34 AM
 *
 * @author: yanzhiwen
 */
public abstract class BaseMvpFragment extends Fragment implements BaseView {
    private FragmentMvpProxy mFragmentMvpProxy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentMvpProxy = createFragmentMvpProxy();
        mFragmentMvpProxy.bindAndCreatePresenter();
    }

    private FragmentMvpProxy createFragmentMvpProxy() {
        if (mFragmentMvpProxy == null) {
            mFragmentMvpProxy = new FragmentMvpProxyImpl<>(this);
        }
        return mFragmentMvpProxy;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initData();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentMvpProxy.unbindPresenter();
    }
}
