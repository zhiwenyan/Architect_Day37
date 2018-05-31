package com.darren.architect_day36.simple8.Base;

/**
 * Description:
 * Data：1/23/2018-2:17 PM
 *
 * @author: yanzhiwen
 */
public class BasePresenter<V extends BaseView> {
    //目前有两个公用的方法，传递的时候会有不同的View？怎么办？用泛型解决
    private V mView;
    //View有一个特点 都是接口
    //GC的回收机制算法

    /**
     * 绑定
     */
    public void attach(V view) {
        this.mView = view;

    }

    /**
     * 解绑
     */
    public void detach() {
        this.mView = null;
    }

    public V getView() {
        return mView;
    }
}
