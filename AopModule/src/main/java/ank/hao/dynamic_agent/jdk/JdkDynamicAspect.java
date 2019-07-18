package ank.hao.dynamic_agent.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAspect implements InvocationHandler {

    private UserAction userAction;

    public JdkDynamicAspect(UserAction userAction){
        this.userAction = userAction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk dynamic proxy start..");
        Object invoke = method.invoke(userAction, args);
        System.out.println("jdk dynamic proxy end..");

        return invoke;
    }
}
