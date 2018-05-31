package com.darren.architect_day36.simple12.proxy;

/**
 * Description:
 * Data：1/24/2018-11:39 AM
 *
 * @author: yanzhiwen
 */
public interface IMvpProxy {
    //创建绑定
    void bindAndCreatePresenter();
    //解绑
    void unbindPresenter();
}
