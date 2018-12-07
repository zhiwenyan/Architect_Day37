package com.darren.architect_day36.retrofit;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hcDarren on 2017/12/16.
 * 请求后台访问数据的 接口类
 */
public interface ServiceApi {
    // 接口涉及到解耦，userLogin 方法是没有任何实现代码的
    // 如果有一天要换 GoogleHttp

    @POST("LoginServlet")
// 登录接口 GET(相对路径)
    Observable<BaseResult<UserInfo>> queryUserInfo(
            // @Query(后台需要解析的字段)
            @Query("userName") String username);


    // 接口涉及到解耦，userLogin 方法是没有任何实现代码的
    // 如果有一天要换 GoogleHttp

    @POST("LoginServlet")
// 登录接口 GET(相对路径)
    Observable<BaseResult<List<UserInfo>>> queryListUserInfo(
            // @Query(后台需要解析的字段)
            @Query("userName") String username);
}
