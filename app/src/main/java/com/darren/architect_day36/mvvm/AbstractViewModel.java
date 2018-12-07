package com.darren.architect_day36.mvvm;

import android.databinding.ViewDataBinding;

/**
 * Description:
 * Data：10/17/2018-4:05 PM
 *
 * @author yanzhiwen
 */
public abstract class AbstractViewModel<T extends ViewDataBinding> implements BaseViewModel {
    public T mViewDataBinding;

    public AbstractViewModel(T viewDataBinding) {
        this.mViewDataBinding = viewDataBinding;
    }

    @Override
    public void onDestroy() {
        mViewDataBinding.unbind();
    }
}
