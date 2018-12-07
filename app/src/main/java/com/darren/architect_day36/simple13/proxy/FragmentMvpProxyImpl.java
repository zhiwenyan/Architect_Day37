package com.darren.architect_day36.simple13.proxy;

import com.darren.architect_day36.simple13.base.BaseView;

/**
 * Description:
 * Data：11/26/2018-10:18 AM
 *
 * @author yanzhiwen
 */
public class FragmentMvpProxyImpl<V extends BaseView> extends MvpProxyImpl<V> implements FragmentMvpProxy {
    public FragmentMvpProxyImpl(V view) {
        super(view);
    }
}
