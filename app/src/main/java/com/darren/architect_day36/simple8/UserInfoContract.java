package com.darren.architect_day36.simple8;

import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple8.Base.BaseView;

import rx.Observable;

/**
 * Description:协议类  这个类可有可无
 * Data：1/23/2018-1:12 PM
 *
 * @author: yanzhiwen
 */
public class UserInfoContract {
    // user View 层
    interface UserInfoView extends BaseView {
        void onLoading();

        void onError();

        void onSucceed(UserInfo userInfo);
    }

    // user presenter 层
    interface UserInfoPresenter {
        void getUsers(String token);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface UserInfoModel {
        Observable<UserInfo> getUsers(String token);
    }
}
