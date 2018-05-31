package com.darren.architect_day36.simple6;

import com.darren.architect_day36.retrofit.BaseSubscriber;
import com.darren.architect_day36.retrofit.UserInfo;

/**
 * Description:
 * Data：1/23/2018-1:12 PM
 *
 * @author: yanzhiwen
 */
public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter {
    //肯定会持有Model和View
    private UserInfoContract.UserInfoView mUserInfoView;
    private UserInfoContract.UserInfoModel mUserInfoModel;

    public UserInfoPresenter(UserInfoContract.UserInfoView userInfoView) {
        mUserInfoView = userInfoView;
        mUserInfoModel = new UserInfoModel();
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
            }

            @Override
            public void onNext(UserInfo userInfo) {
                //成功
                mUserInfoView.onSucceed(userInfo);
            }
        });
    }
}
