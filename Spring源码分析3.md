## 1. 获取bean实例主流程.
1. 转换beanName,获取注册bean时的名称；
2. 早期检查单例缓存；
3. 校验是否已经在创建，排除循环依赖；
4. 检查bean是否在注册在DefaultListableBeanFactory中，如果没有且parentBeanFactory不为空，则使用parentBeanFactory创建bean；
5. 检查如果typeCheckOnly为false，标记beanName为已创建；
6. 把beanDefinition转换成RootBeanDefinition，且检查beanDefinition不是abstract；
7. 如果有depend-on属性依赖的beans，先保证所依赖bean的初始化；
8. 创建bean实例；(根据scope不同而不同)；
9. 如果requiredType不为空，检查实例化的bean是否匹配需要的类型.

## 2. 你真的了解Spring吗.
1. 假如beanClass是cn.com.dd.TestBean，beanName取值：id->name(无id)->cn.com.dd.TestBean#0(无id、name)；如果连class都没有，但是有
   parent，则是parentName$child#0；