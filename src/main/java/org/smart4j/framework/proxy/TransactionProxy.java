package org.smart4j.framework.proxy;

import org.apache.log4j.Logger;
import org.smart4j.annotation.Transaction;
import org.smart4j.helper.DatabaseHelper;

import java.lang.reflect.Method;

/**
 * 事务代理类
 * Created by dkw on 2017/8/16.
 */
public class TransactionProxy implements Proxy {
    private static Logger log = Logger.getLogger(TransactionProxy.class);
    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                log.debug("commit transcation");
            } catch (Exception e) {
                DatabaseHelper.rollbackTranscation();
                log.debug("rollback transcation");
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }
}
