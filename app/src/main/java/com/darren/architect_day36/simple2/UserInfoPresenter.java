package com.darren.architect_day36.simple2;

import com.darren.architect_day36.retrofit.BaseSubscriber;
import com.darren.architect_day36.retrofit.UserInfo;

/**
 * Created by hcDarren on 2018/1/1.
 */
public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter{
    // 肯定会持有 V 和 M
    private UserInfoContract.UserInfoView mView;
    private UserInfoContract.UserInfoModel mModel;

    public UserInfoPresenter(UserInfoContract.UserInfoView view){
        this.mView = view;
        mModel = new UserInfoModel();
    }

    @Override
    public void getUsers(String token) {
        // RxJava  + OkHttp + Retrofit
        // 网络引擎 + OkHttp
        // 显示正在加载中
        mView.onLoading();
        // 耗时 3s
        mModel.getUsers(token).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                // 失败
                mView.onError();
            }

            @Override
            public void onNext(UserInfo userInfo) {
                // 成功
                mView.onSucceed(userInfo);
            }
        });
    }
}
