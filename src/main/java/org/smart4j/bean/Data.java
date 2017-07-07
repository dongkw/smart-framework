package org.smart4j.bean;

/**
 * 返回数据对象
 * Created by dkw on 2017/7/3.
 */
public class Data {
    /**
     * 数据模型
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return this.model;
    }
}
