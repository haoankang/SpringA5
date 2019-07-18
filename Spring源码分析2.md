##1. 标签的解析和注册流程.
上一章，大致说明了bean的加载、解析和注册流程；这里详细分析下bean的解析，也就是标签的解析过程；
###1.1 默认标签的解析
```
private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        if (delegate.nodeNameEquals(ele, "import")) {
            this.importBeanDefinitionResource(ele);
        } else if (delegate.nodeNameEquals(ele, "alias")) {
            this.processAliasRegistration(ele);
        } else if (delegate.nodeNameEquals(ele, "bean")) {
            this.processBeanDefinition(ele, delegate);
        } else if (delegate.nodeNameEquals(ele, "beans")) {
            this.doRegisterBeanDefinitions(ele);
        }
    }
```   
这里先分析bean标签的解析过程，整个过程如下：
1. 首先委托BeanDefinitionParserDelegate的parseBeanDefinitionElement(Element ele)进行元素解析，返回包含BeanDefinition对象
的BeanDefinitionHolder对象，BeanDefinitionHolder对象已经包含了xml中配置的各种bean属性，包括id,name,alias等；
2. 当返回的BeanDefinitionHolder对象不为null的情况下，如果默认标签的的子节点下再有自定义属性，还需要再次对自定义标签进行解析；
3. 然后开始注册bean的过程，最终以Map<String, BeanDefinition>形式存储在内存中；
4. 通知相关的监视器，这个bean已经加载完成；
```
protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
        BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);
        if (bdHolder != null) {
            bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);
            try {
                BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, this.getReaderContext().getRegistry());
            } catch (BeanDefinitionStoreException var5) {
                this.getReaderContext().error("Failed to register bean definition with name '" + bdHolder.getBeanName() + "'", ele, var5);
            }
            this.getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));
        }
    }
```
各个流程的详细部分不一一说明了，因为太长，这里只说明部分特性：
1. bean的注册beanName的生成规则(优先级)是：id、name（如果有多个，取第一个）、按照一定规则生成；
2. beanDefinition的默认使用类是GenericBeanDefinition；
3. 自定义标签的解析handler默认配置在META-INF/spring.handlers;

###1.2 自定义标签的解析
1. 自定义标签的使用
* 创建一个需要扩展的组件
* 定义一个XSD文件描述组件内容
* 实现BeanDefinitionParser接口，解析XSD文件中的定义和组件定义
* 创建一个Handler文件，扩展自NamespaceHandlerSupport，用来将组件注册到spring容器
* 编写spring.handlers和spring.schemas
2. 自定义标签的解析
* 获取标签的命名空间
* 获取自定义标签处理器
* 标签解析

##遗留问题
1. 解析的全过程，各个类之间的关系（如NamespaceHandlerParser)