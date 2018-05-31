package com.darren.architect_day36.simple12;

import com.darren.architect_day36.retrofit.BaseSubscriber;
import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple12.base.BasePresenter;

/**
 * Description:
 * Data：1/23/2018-1:12 PM
 *
 * @author: yanzhiwen
 */
public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView,UserInfoModel> implements UserInfoContract.UserInfoPresenter {
    //是直接new还是？一个Presenter对应多个Model怎么解决？new 很正常，尽量分离（六大基本原则）
    //一般情况下是一个Presenter对应一个Model，如果说有多一对多的情况
    //写一个 一对一的情况
    @Override
    public void getUsers(String token) {
        //RxJava+okHttp+Retrofit
        //网络引擎
        //OkHttp
        //在加载之前，显示正在加载中...
        getView().onLoading();
        getModel().getUsers(token).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                //失败，每次都需要去判断View==null，这个怎么办？？？？
                //都是接口 通用代码View!=null 统一处理 这个是AOP （aspectj 动态代理）
                getView().onError();
            }

            @Override
            public void onNext(UserInfo userInfo) {
                //成功
                getView().onSucceed(userInfo);
            }
        });
    }
}
