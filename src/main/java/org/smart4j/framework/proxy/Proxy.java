package org.smart4j.framework.proxy;

/**
 * 代理接口
 * Created by dkw on 2017/7/7.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
