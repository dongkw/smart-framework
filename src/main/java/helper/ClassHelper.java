package helper;

import annotation.Controller;
import annotation.Service;
import util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 * Created by dkw on 2017/6/30.
 */
public final class ClassHelper {
    /**
     * 定义类集合
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取所有类
     *
     * @return classSet
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取所有service类
     *
     * @return classSet
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取所有Controller类
     *
     * @return classSet
     */
    public static Set<Class<?>> getControllerlassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包下面所有的bean类（Controller, Service）
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerlassSet());
        return beanClassSet;
    }
}
