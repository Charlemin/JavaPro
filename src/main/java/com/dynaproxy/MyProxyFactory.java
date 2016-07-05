package com.dynaproxy;

import java.lang.reflect.Proxy;

/**
 * Created by Eric on 2016/7/4.
 */
public class MyProxyFactory {

    public static Object getProxy(Object target) throws Exception {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }

}
