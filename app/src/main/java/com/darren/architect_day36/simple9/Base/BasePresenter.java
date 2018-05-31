package com.darren.architect_day36.simple9.Base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * Data：1/23/2018-2:17 PM
 *
 * @author: yanzhiwen
 */
public class BasePresenter<V extends BaseView> {
    //目前有两个公用的方法，传递的时候会有不能View？怎么办？用泛型解决
    private WeakReference<V> mViewReference;
    private V mProxyView;
    //View 一般是Activity 会涉及到内存泄露 但是已经解绑了不会，如果没有就会泄露，最好还是用下弱引用
    //View有一个特点 都是接口
    //GC的回收机制算法

    /**
     * 绑定
     */
    public void attach(V view) {
        this.mViewReference = new WeakReference<>(view);
        //用代理对象  调用对象的某个方法，你前面并不会去判断它是不是空
        mProxyView = (V) Proxy.newProxyInstance(getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //动态代理对象会每次调用这个方法
                if (mViewReference == null || mViewReference.get() == null) {
                    return null;
                }
                //调用方法
                return method.invoke(mViewReference.get(), args);
            }
        });
    }

    /**
     * 解绑
     */
    public void detach() {
        this.mViewReference = null;
        this.mProxyView = null;
    }

    public V getView() {
        return mProxyView;
    }
}
