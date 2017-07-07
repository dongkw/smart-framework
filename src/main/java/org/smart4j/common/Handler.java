package org.smart4j.common;

import java.lang.reflect.Method;

/**
 * Created by dkw on 2017/7/3.
 */
public class Handler {
    /**
     * Controller类
     */
    private Class<?> controllerClass;
    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return this.controllerClass;
    }

    public Method getActionMethod() {
        return this.actionMethod;
    }
}
