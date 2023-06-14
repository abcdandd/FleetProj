package com.gaokun.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author gaokun
 * @version 1.0
 * @date 2023/6/10 20:08
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface CountTime {

}
