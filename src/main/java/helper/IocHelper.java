package helper;

import annotation.Inject;
import org.apache.commons.lang3.ArrayUtils;
import util.ArrayUtil;
import util.CollectionUtil;
import util.RefiectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入
 * Created by dkw on 2017/7/3.
 */
public class IocHelper {
    static {
        //提前所有bean类与bea实例之间的映射关系
        Map<?, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历bean Map
            for (Map.Entry<?, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = (Class<?>) beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean 定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历所有BeanField
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                RefiectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
