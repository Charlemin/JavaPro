package com.dynaproxy;

/**
 * Created by Eric on 2016/7/4.
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
