package com.darren.architect_day36.simple4;

import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple4.base.BaseView;

import rx.Observable;

/**
 * Created by Darren
 * 这个类可有可无，一个协议类，多人协作开发的时候，就可以先把这个写好
 */
public class UserInfoContract {
    // user View 层
    interface UserInfoView extends BaseView{
        // 1.正在加载中
        // 2.获取出错了
        // 3.成功了要显示数据
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
