package com.wechat.pay.v3.applyment.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义敏感信息字段注解
 *
 * @author LYJ
 * @date 2021/1/15 13:47
 * @since 1.0
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecEncrypt {
}
