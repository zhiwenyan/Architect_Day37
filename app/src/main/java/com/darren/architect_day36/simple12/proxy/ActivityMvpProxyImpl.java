package com.darren.architect_day36.simple12.proxy;

import com.darren.architect_day36.simple12.base.BaseView;

/**
 * Description:
 * Data：1/24/2018-11:39 AM
 *
 * @author: yanzhiwen
 */
public class ActivityMvpProxyImpl<V extends BaseView> extends MvpProxyImpl<V> implements ActivityMvpProxy {

    public ActivityMvpProxyImpl(V view) {
        super(view);
    }
}
