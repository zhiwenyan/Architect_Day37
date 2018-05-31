package com.darren.architect_day36.simple13.proxy;

/**
 * Created by hcDarren on 2018/1/6.
 */

public interface IMvpProxy {
    void bindAndCreatePresenter();// 一个是和创建绑定
    void unbindPresenter();// 一个是解绑
}
