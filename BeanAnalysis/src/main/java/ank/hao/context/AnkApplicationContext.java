package ank.hao.context;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class AnkApplicationContext extends ClassPathXmlApplicationContext {

    public AnkApplicationContext(String resources){
        super(resources);
    }

    public void initPropertySources() {
//        for(Map.Entry entry:getEnvironment().getSystemProperties().entrySet()){
//            System.out.println(entry.getKey()+"---"+entry.getValue());
//        }
        logger.error("校验故意失败，啦啦啦");
    }

    public void validateRequiredProperties() {
        logger.error("校验必要配置");
    }
}
