package helper;

import util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by dkw on 2017/7/3.
 */
public class Loader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
