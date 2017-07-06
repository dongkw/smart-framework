package helper;


import annotation.Action;
import common.Handler;
import common.Request;
import util.ArrayUtil;
import util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存放请求与处理器的映射关系 简称（Action Map）
 * Created by dkw on 2017/7/3.
 */
public class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP=new HashMap<>();
    static {
        //获取所有controller
        Set<Class<?>> controllerClassSet=ClassHelper.getControllerlassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)){
            for (Class<?> controllerClass:controllerClassSet){
                //获取controller中的方法
                Method[] methods=controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    for (Method method:methods){
                        //从Action 中获取URL规则的映射
                        Action action=method.getAnnotation(Action.class);
                        String mapping=action.value();
                        //验证url映射规则
                        if (mapping.matches("\\w+:/\\w*")){
                            String[] array=mapping.split(":");
                            if (ArrayUtil.isNotEmpty(array)&&array.length==2){
                                String requestMathod=array[0];
                                String requestPath=array[1];
                                Request request=new Request(requestMathod,requestPath);
                                Handler handler=new Handler(controllerClass,method);
                                ACTION_MAP.put(request,handler);

                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
