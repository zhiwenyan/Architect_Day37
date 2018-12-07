package com.darren.architect_day36.simple12.proxy;

import com.darren.architect_day36.simple12.base.BasePresenter;
import com.darren.architect_day36.simple12.base.BaseView;
import com.darren.architect_day36.simple12.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Data：1/24/2018-11:44 AM
 *
 * @author: yanzhiwen
 */
public class MvpProxyImpl<V extends BaseView> implements IMvpProxy {
    private V mView;
    private List<BasePresenter> mPresenters;

    public MvpProxyImpl(V view) {
        //判断下是不是 个接口 是不是为NULL
        this.mView = view;
        mPresenters = new ArrayList<>();
    }

    @Override
    public void bindAndCreatePresenter() {

        //1 Activity ? ViewGroupMvpProxy ? Fragment?抽离 工具类抽出去，或者把每个代码copy一份
        //今天你可以抽离目前一部分 注入代码+额外功能+还有一些其他的地方有不一样
        //注入Presenter 通过反射(或者Dagger)
        Field[] fields = mView.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                //创建注入3
                Class<? extends BasePresenter> presenterClazz;
                // try {
                //自己判断下，获取继承的父类 如果不是继承BasePresenter 就抛异常
                //获取这个类
                //编译器在运行的时候会对我们的泛型进行擦除（泛型擦除一般是针对系统的，我们指定的泛型信息都是会保留的），
                // 在写代码是同一类型，在编译成Class字节码后泛型会进行擦除
                presenterClazz = ( Class<? extends BasePresenter> ) field.getType(); //泛型擦除
                //} catch (Exception e) {
                // 乱七八糟一些注入
                //    throw new RuntimeException("不支持的类型");
                //  }
                //判断presenterClazz是不是继承BasePresenter
                if (!BasePresenter.class.isAssignableFrom(presenterClazz)) {
                    throw new RuntimeException("no support type" + presenterClazz.getName());
                }
                BasePresenter basePresenter = null;
                try {
                    //创建BasePresenter对象
                    basePresenter = presenterClazz.newInstance();
                    basePresenter.attach(mView);
                    mPresenters.add(basePresenter);
                    field.setAccessible(true);
                    field.set(mView, basePresenter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //检测
                checkView(basePresenter);
            }

        }
    }

    /**
     * 检测我们的View是否实现了BasePresenter的View接口
     *
     * @param basePresenter
     */
    private void checkView(BasePresenter basePresenter) {
        //1、Presenter的View接口
        Type[] types = (( ParameterizedType ) (basePresenter.getClass().getGenericSuperclass())).getActualTypeArguments();
        Class viewClass = ( Class ) types[0];
        //2、要拿到View层的所有接口
        Class[] viewClasses = mView.getClass().getInterfaces();
        //3、View层没有实现就抛异常
        boolean isImplementsView = false;
        for (Class viewClazz : viewClasses) {
            if (viewClass.isAssignableFrom(viewClazz)) {
                isImplementsView = true;
            }
        }
        if (!isImplementsView) {
            throw new RuntimeException("View must implements" + viewClass.getName());
        }
    }


    @Override
    public void unbindPresenter() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detach();
        }
        mView = null;

    }
}
