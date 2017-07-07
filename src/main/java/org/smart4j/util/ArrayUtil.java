package org.smart4j.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * Created by dkw on 2017/7/3.
 */
public final class ArrayUtil {
    private ArrayUtil() {
    }

    /**
     * 判断数组是否非空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

}
