##1. 解析Spring源码WWW原则
 * what—— spring现在已经算是java开发的基石了，核心是IOC和AOP.
 * why—— 1.既然作为基石，需要更加彻底的了解并掌握它，工作中可能用不到太细节的东西，但出了问题
            就不好找原因，因此解析源码可以了解一些底层细节；2. Spring作为一个基础框架，可以
            通过阅读源码的方式来入门源码解析的门槛，提升自己的各方面能力；
 * how—— 源码太多有60w行，但不需要全部去从头到尾阅读，也没必要；这里作为个人阅读的
           方法：1. 根据实际使用作为入口，来解析主要功能和必要的细节； 2. 带着问题，例如bean
           的scope，几种方式怎么实现的？spring的xml约束文档DTD和XSD，怎么找到的？等等.
           3. 从简到繁，spring源码包含20+个module，我们需要从最基本的功能开始解析，这里可以
           通过观察各module之间的依赖来了解熟悉.
---
##2. Spring最基础模块spring-beans
  1. 依赖于spring-core(作为spring的基础工具包).
  2. 容器的基本用法：
     创建一个xml文件，基于XmlBeanFactory(已废弃，官方推荐用DefaultListableBeanFactory+XmlBeanDefinitionReader来替代)去解析，
     从而获得bean.
     ```
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Resource resource = new ClassPathResource("spring.xml");
        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(resource);
        TestBean testBean = beanFactory.getBean(TestBean.class);
     ```
     Bean的加载过程：加载解析静态配置文件，转换成BeanDefinition，基于BeanDefinition创建bean实例;
  3. Bean的解析和注册
     * Resource,继承InputStreamSource,主要负责资源的加载管理，可以通过实现Resource来实现自己的资源加载；
         ```
            public interface Resource extends InputStreamSource {
                boolean exists();
            
                default boolean isReadable() {
                    return true;
                }
            
                default boolean isOpen() {
                    return false;
                }
            
                default boolean isFile() {
                    return false;
                }
            
                URL getURL() throws IOException;
            
                URI getURI() throws IOException;
            
                File getFile() throws IOException;
            
                default ReadableByteChannel readableChannel() throws IOException {
                    return Channels.newChannel(this.getInputStream());
                }
            
                long contentLength() throws IOException;
            
                long lastModified() throws IOException;
            
                Resource createRelative(String var1) throws IOException;
            
                @Nullable
                String getFilename();
            
                String getDescription();
            }
         ```
         一些重要的方法：
         - getInputStream(): 找到并打开资源，返回InputStream从资源中读取的内容；每次调用都会返回一个新的InputStream,
                调用者需要关闭流.
         - exists(): 返回资源是否实际以物理形式存在.
         - isOpen(): 返回一个指示资源是否表示具有打开流的句柄。如果true,IputStream不能多次读取，必须只读一次然后关闭
                以避免资源泄露。false是所有常规资源实现的返回值；这里涉及到jdk1.8的一个新特性：接口中可以有默认方法.
         一些内置Resource实现：
         + UrlResource: 
     