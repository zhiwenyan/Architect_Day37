package com.darren.architect_day36.retrofit;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class UserInfo {
    public int id;
    public String userName;
    public String userSex;

    public UserInfo() {
    }

    public UserInfo(int id, String userName, String userSex) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
    }

}
