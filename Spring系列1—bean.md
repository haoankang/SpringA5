## 1. 一些基本知识.
1.bean的命名规则.
> 一般而言，bean命名优先级id——>name——>alias——>缺省名称；如果有多个，均指向同一个bean；
<p>

2.实例化bean的三种方式.
> a. 构造函数实例化. b. 使用静态工厂方法实例化. c. 使用实例工厂方法实例化.
<p>

3.依赖注入.
> 依赖注入两种方式. a. 基于构造函数的依赖注入. b. 基于setter的依赖注入.<p>
  其他相关：依赖depend-on，lazy-init，autowire和autowire-candidate.
  重点lookup-method，查找方法注入，可以用来处理单例中引入原型scope.
<p>

4.bean的作用域scope.
> singleton. prototype. request. session. application. websocket.
  不同的scope bean之间依赖时，例如request作用域注入到singleton作用域bean时，
  两种方式：使用代理方式<aop:scoped-proxy/>，也可以注入类实现ObjectFactory<T>，
  每次获取时会调用getObject()方法获取实例.<p>
  
5.定制bean的本质.
> a. 生命周期回调.<br>
    使用不同的初始化方法为同一个bean配置多个生命周期机制，调用如下：
    1. @PostConstruct. 2. 实现InitializingBean的afterPropertiesSet()方法.
    3. 自定义init()方法，指定<init-method>. <br>
    销毁方法以下顺序：
    1. @PreDestory. 2. 实现DisposableBean的destory()回调方法. 3. 自定义destory()方法.
  b. 容器感知接口——ApplicationContextAware和BeanNameAware以及其他.<p>
  
6.bean的定义继承.
> 可以继承scope、构造函数参数值、属性值和方法覆盖.<p>

7.context扩展点.
> FactoryBean和ObjectFactory都属于工厂模式用来创建对象使用的；不同点：通过FactoryBean可以
控制对象如何创建，而ObjectFactory借助Scope接口自定义Scope控制对象的创建时机.<p>
> BeanPostProcessor和BeanFactoryPostProcessor.都是Spring初始化bean时对外提供的扩展点，
使用场景不同（生命周期节点不同）：BeanFactoryPostProcessor在spring的bean创建之前，可以读取
beanFactory读取修改元数据，可以配置多个，用Order属性控制执行次序，内置的一些BeanFactoryPostProcessor
实现类，常用的有：org.springframework.beans.factory.config.PropertyPlaceholderConfigurer,
org.springframework.beans.factory.config.PropertyOverrideConfigurer等；<br>
BeanPostProcessor是在容器加载了bean的定义文件并且实例化之后执行的;内置的一些BeanPostProcessor
实现类包括：
>>* org.springframework.context.annotation.CommonAnnotationBeanPostProcessor：支持@Resource注解的注入
>>* org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor：支持@Required注解的注入
>>* org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor：支持@Autowired注解的注入
>>* org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor：支持@PersistenceUnit和@PersistenceContext注解的注入
>>* org.springframework.context.support.ApplicationContextAwareProcessor：用来为bean注入ApplicationContext等容器对象
<p>

8.配置的三种方式：基于xml、基于注解、基于javaConfig，可以混合使用.个人倾向用注解和javaConfig混用.
> @Resource和@Autowired不同点：@Autowired是spring提供的注解，只按照byType注入，如果想要
使用byName来装配，可以结合@Qualifier注解一起使用；@Resource默认按照byName自动注入，由J2EE
提供，支持byName和byType.
<p>

9.其他汇总.
> 1. 环境抽象@Profile，激活相关spring.profiles.active和spring.profiles.default.
> 2. 对于一个通用的StandardServletEnvironment，完整的层级如下所示，优先级依次降低.
    >>1. ServletConfig parameters.
    >>2. ServletContext params.
    >>3. JNDI环境变量.
    >>4. JVM环境变量(命令行-D).
    >>5. JVM环境变量.<p>
> 3. PropertySource引入自定义配置文件.
> 4. ApplicationContext的附加功能.
>>* 使用MessageSource国际化.
>>* 标准和自定义事件.


