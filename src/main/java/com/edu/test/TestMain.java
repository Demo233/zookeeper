package com.edu.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMain {

    public static void main(String[] args){
        Proxy.newProxyInstance(Test.class.getClassLoader(), new Class<?>[]{Test.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                return null;
            }
        });
    }

}