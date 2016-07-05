package com.dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Eric on 2016/7/4.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TxUtil tx = new TxUtil();
        tx.beginTx();
        Object result = method.invoke(target,args);
        tx.endTx();
        return result;
    }
}
