package ank.hao.dynamic_agent.cglib;

import ank.hao.dynamic_agent.jdk.UserAction;
import ank.hao.dynamic_agent.jdk.UserAdd;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * cglib可以对实现类进行代理，分析生成的动态代理类可知，是通过继承实现类的方式代理
 * 生成的动态代理类class className extends SuperClass implements Factory
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        UserAdd userAction = new UserAdd();
        MethodInterceptor methodInterceptor = new MethodInterceptorImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userAction.getClass());
        enhancer.setCallback(methodInterceptor);

        UserAdd userAdd = (UserAdd) enhancer.create();
        userAdd.doo();
    }
}
