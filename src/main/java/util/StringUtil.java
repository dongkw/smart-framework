package util;

import org.apache.commons.lang3.StringUtils;

    /**
     * Created by dkw on 2017/6/28.
     */
public final class StringUtil {
    private StringUtil(){

    }
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);

    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

        /**
         * 字符串转换数组
         * @param str
         * @param splitStr
         * @return
         */
    public static String[] splitString(String str,String splitStr){
        return str.split(splitStr);
    }

}
