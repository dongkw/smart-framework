package org.smart4j.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by dkw on 2017/7/7.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     * @return
     */
    Class<? extends Annotation> value();
}
