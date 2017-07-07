package org.smart4j.bean;

import org.smart4j.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by dkw on 2017/7/3.
 */
public class Param {
private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名称获取long类型参数
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */

    public Map<String, Object> getMap() {
        return this.paramMap;
    }
}
