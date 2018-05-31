package com.darren.architect_day36.simple7;

import com.darren.architect_day36.retrofit.BaseSubscriber;
import com.darren.architect_day36.retrofit.UserInfo;

/**
 * Description:
 * Data：1/23/2018-1:12 PM
 *
 * @author: yanzhiwen
 */
public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter {
    //肯定会持用Model和View
    private UserInfoContract.UserInfoView mUserInfoView;
    private UserInfoContract.UserInfoModel mUserInfoModel;

    public UserInfoPresenter() {
        mUserInfoModel = new UserInfoModel();
    }

    /**
     * 绑定
     *
     * @param view
     */
    public void attach(UserInfoContract.UserInfoView view) {
        this.mUserInfoView = view;
    }

    /**
     * 解绑View 加了这个之后会越来越复杂，代码写起来会越来越多？怎么办？
     * 问题是 很多代码时反复用到的 attach detach每个Presenter都会有
     * Activity -》View的Activity attach detach每个View层也要有
     */
    public void detach() {
        this.mUserInfoView = null;
    }

    @Override
    public void getUsers(String token) {
        //RxJava+okHttp+Retrofit
        //网络引擎
        //OkHttp
        //在加载之前，显示正在加载中...
        mUserInfoView.onLoading();
        mUserInfoModel.getUsers(token).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                //失败
                if (mUserInfoView != null) {
                    mUserInfoView.onError();
                }
            }

            @Override
            public void onNext(UserInfo userInfo) {
                //成功
                if (mUserInfoView != null) {
                    mUserInfoView.onSucceed(userInfo);
                }
            }
        });
    }
}
