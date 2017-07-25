package org.smart4j.loader;

import org.smart4j.helper.*;
import org.smart4j.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by dkw on 2017/7/3.
 */
public class Loader {
    public static void init() {

        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            //在此处加载的类必须设置isInitialized属性值为true;
            ClassUtil.loadClass(cls.getName(),true);

        }

    }
}
