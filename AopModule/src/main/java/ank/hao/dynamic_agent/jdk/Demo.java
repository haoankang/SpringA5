package ank.hao.dynamic_agent.jdk;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理只能代理有实现接口的class
 * 因为根据生成的代理类反编译，可以看出代理类的形式是class Proxy* extends Proxy implements Iterfaces*
 * 因为要作为接口实现，所以必要要有接口类
 */
public class Demo {

    public static void main(String[] args) {
        UserAction userAction = new UserAdd();

        UserAction o = (UserAction)Proxy.newProxyInstance(userAction.getClass().getClassLoader(), new Class[]{UserAction.class},
                new JdkDynamicAspect(userAction));

        o.doo();
    }
}
