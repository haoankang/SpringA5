package ank.hao.dynamic_agent.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy start..");

        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib proxy end..");
        return object;
    }
}
