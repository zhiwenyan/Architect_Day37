package com.darren.architect_day36.simple13;

import android.widget.TextView;

import com.darren.architect_day36.R;
import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple13.base.BaseMvpActivity;
import com.darren.architect_day36.simple13.inject.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

// 这个地方可以放个泛型，方便 1 对 1 ，去掉了
public class MainActivity extends BaseMvpActivity implements UserInfoContract.UserInfoView {
    // @InjectPresenter// 这个注解只允许添加在 Presenter 上面
    private TextView mUserInfoTv;
    // 抛出一个问题留在这里，多 Presenter 怎么处理，dagger ，自己写 Dagger 处理
    // 一个 View 里面肯定会有多个 Presneter 的情况，怎么处理 Dagger 处理 有时间会补一下 ，自己写一个注入
    // 对个 new  自己手动去 attach  和 detach
    @InjectPresenter
    private UserInfoPresenter mPresenter1;
    @InjectPresenter
    private UserInfoPresenter mPresenter2;

    public void initTitle() {
        // 可以用封装，可以把它抛出出，哪怕是单独写一个工具类

    }

    @Override
    public void onLoading() {
        // 加载进度条
    }

    @Override
    public void onError() {
        // 显示错误
        // 起到一个约束作用，写代码的时候只能是同一类型，在编译生成 Class 字节码后泛型会进行擦除 也就等同于 List list = new ArrayList()
        // 泛型擦除一般是针对系统自带的，我们自己指定的泛型信息一般都是会保留的
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        // list.add(1);
    }

    @Override
    //@CheckLogin
    public void onSucceed(List<UserInfo> userInfo) {
        // 成功 这个时候 Activity 有可能会被关闭掉，有可能会异常崩溃（一般不会）
        // 1. 可以判断界面还在不在(试一试)
        // 2. 采用解绑（通用）
        mUserInfoTv.setText(userInfo.get(0).userName);
    }

//    @Override
//    protected UserInfoPresenter createPresenter() {
//        return new UserInfoPresenter();
//    }

    @Override
    protected void initData() {
        mPresenter2.getUsers("Steven");
    }

    @Override
    protected void initView() {
        mUserInfoTv = ( TextView ) findViewById(R.id.user_info_tv);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }
}
