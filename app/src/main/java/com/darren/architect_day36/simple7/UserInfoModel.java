package com.darren.architect_day36.simple7;

import com.darren.architect_day36.retrofit.RetrofitClient;
import com.darren.architect_day36.retrofit.UserInfo;

import rx.Observable;

/**
 * Description:
 * Data：1/23/2018-1:11 PM
 *
 * @author: yanzhiwen
 */
public class UserInfoModel implements UserInfoContract.UserInfoModel{
    // Model 获取数据
    @Override
    public Observable<UserInfo> getUsers(String token){
        return RetrofitClient.getServiceApi()
                .queryUserInfo(token)
                // .subscribeOn().observeOn().subscribe()
                // Subscriber 封装一下
                // 第二个坑 , 坑我们 返回值都是一个泛型，转换返回值泛型
                .compose(RetrofitClient.<UserInfo>transformer());
    }
}
