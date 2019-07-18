package ank.hao.context;

import ank.hao.beans.bean.ConstructorBean;
import ank.hao.beans.bean.DIABean;
import ank.hao.beans.bean.TestBean;
import org.springframework.context.ApplicationContext;

public class Demo2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnkApplicationContext("spring.xml");
        //applicationContext.getBean(TestBean.class);
//        applicationContext.getBean("testBean3");
//        applicationContext.getBean("testBean");
//
//        applicationContext.getBean(ConstructorBean.class);

        TestBean testBean = applicationContext.getBean("testBean4", TestBean.class);
        testBean.say();
//        TestBean testBean1 = applicationContext.getBean("testBean5", TestBean.class);
//        testBean1.say();

//        applicationContext.getBean(DIABean.class);
        ((AnkApplicationContext) applicationContext).close();
    }
}
