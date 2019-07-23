package ank.hao.lwt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@ComponentScan(basePackages = {"ank.hao.lwt"})
@EnableLoadTimeWeaving
@EnableAspectJAutoProxy
public class Config {
}
