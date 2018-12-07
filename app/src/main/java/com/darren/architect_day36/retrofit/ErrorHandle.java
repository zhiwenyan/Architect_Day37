package com.darren.architect_day36.retrofit;

/**
 * Created by hcDarren on 2017/12/23.
 */

public class ErrorHandle {

    public static class ServiceError extends Throwable {
        String errorCode;

        /**
         * @param errorCode 状态码
         * @param errorMsg  错误信息
         */
        public ServiceError(String errorCode, String errorMsg) {
            super(errorMsg);
            this.errorCode = errorCode;
        }
    }

}
