package com.darren.architect_day36.retrofit;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class UserInfo {
    public String au_nickname;
    public String au_sex;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + au_nickname + '\'' +
                ", userPwd='" + au_sex + '\'' +
                '}';
    }
}
