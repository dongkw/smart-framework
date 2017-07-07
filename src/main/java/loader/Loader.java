package loader;

import helper.BeanHelper;
import helper.ClassHelper;
import helper.ControllerHelper;
import helper.IocHelper;
import util.ClassUtil;
import util.PropsUtil;

/**
 * 加载相应的 Helper 类
 * Created by dkw on 2017/7/3.
 */
public class Loader {
    public static void init() {
        new IocHelper();
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
