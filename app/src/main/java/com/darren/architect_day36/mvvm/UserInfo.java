package com.darren.architect_day36.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.darren.architect_day36.BR;

/**
 * Description:
 * Data：9/19/2018-10:07 AM
 *
 * @author yanzhiwen
 */
public class UserInfo extends BaseObservable {
    private String username;
    private int age;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
