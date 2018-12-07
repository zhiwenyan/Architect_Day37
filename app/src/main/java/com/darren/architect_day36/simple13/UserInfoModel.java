package com.darren.architect_day36.simple13;

import com.darren.architect_day36.retrofit.RetrofitClient;
import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple13.base.BaseModel;

import java.util.List;

import rx.Observable;

/**
 * Created by hcDarren on 2018/1/1.
 */

public class UserInfoModel extends BaseModel implements UserInfoContract.UserInfoModel{
    // Model 获取数据
    @Override
    public Observable<List<UserInfo>> getUsers(String token){
        return RetrofitClient.getServiceApi()
                .queryListUserInfo(token)
                //.subscribeOn().observeOn().subscribe()
                // Subscriber 封装一下
                // 第二个坑 , 坑我们 返回值都是一个泛型，转换返回值泛型
                .compose(RetrofitClient.<List<UserInfo>>transformer());
    }
}
