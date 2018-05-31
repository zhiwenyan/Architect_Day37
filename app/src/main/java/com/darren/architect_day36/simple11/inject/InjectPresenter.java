package com.darren.architect_day36.simple11.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * Data：1/23/2018-5:33 PM
 *
 * @author: yanzhiwen
 */
//Target代表放在哪里使用 FIELD属性  METHOD 方法 TYPE类
@Target(ElementType.FIELD)
//什么时候起作用，程序运行起作用 RUNTIME运行时 CLASS编译时 SOURCE编程阶段
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
}
