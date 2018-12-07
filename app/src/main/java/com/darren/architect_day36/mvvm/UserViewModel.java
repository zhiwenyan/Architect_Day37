package com.darren.architect_day36.mvvm;

import com.darren.architect_day36.databinding.ActivityUserInfoBinding;

/**
 * Description:
 * Data：10/17/2018-4:05 PM
 *
 * @author yanzhiwen
 */
public class UserViewModel extends AbstractViewModel<ActivityUserInfoBinding> {

    public UserViewModel(ActivityUserInfoBinding viewDataBinding) {
        super(viewDataBinding);
    }

    public void getUserInfo(String uid, HttpCallback<UserInfo> callback) {
        //从网络或缓存获取信息.
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Tom");
        userInfo.setAge(18);
        callback.onCallBack(userInfo);
    }
}