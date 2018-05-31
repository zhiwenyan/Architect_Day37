package com.darren.architect_day36.simple12.proxy;

import com.darren.architect_day36.simple12.base.BaseView;

/**
 * Description:
 * Data：3/23/2018-11:33 AM
 *
 * @author: yanzhiwen
 */
public class FragmentMvpProxyImpl<V extends BaseView> extends MvpProxyImpl implements FragmentMvpProxy {

    public FragmentMvpProxyImpl(V view) {
        super(view);
    }
}
