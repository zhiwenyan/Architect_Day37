package com.darren.architect_day36.simple11.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Description:
 * Data：1/23/2018-2:17 PM
 *
 * @author: yanzhiwen
 */
public class BasePresenter<V extends BaseView, M extends BaseModel> {
    //目前有两个公用的方法，传递的时候会有不能View？怎么办？用泛型解决
    private WeakReference<V> mViewReference;
    private V mProxyView;
    //View 一般是Activity 会涉及到内存泄露 但是已经解绑了不会，如果没有就会泄露，最好还是用下弱引用
    //View有一个特点 都是接口
    //GC的回收机制算法
    //动态创建Model
    private M mModel;

    /**
     * V
     * 绑定
     */
    public void attach(V view) {
        this.mViewReference = new WeakReference<>(view);
        //用代理对象
        mProxyView = (V) Proxy.newProxyInstance(getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //动态代理对象会每次调用这个方法
                if (mViewReference == null || mViewReference.get() == null) {
                    return null;
                }
                return method.invoke(mViewReference.get(), args);
            }
        });
        //动态创建Model，怎么创建？通过Class反射机制去创建（Activity是怎么创建的？布局的View怎么创建的？反射）
        Type[] params = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        try {
            //最好是判断下类型
            mModel = (M) ((Class) params[1]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 解绑
     */
    public void detach() {
        this.mViewReference.clear();
        this.mViewReference = null;
        this.mProxyView = null;
    }

    public V getView() {
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }
}
