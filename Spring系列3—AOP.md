## Spring AOP基本概念
1.基本术语.
> 通知(Advice)、连接点(JoinPoint)、切入点(PointCut)、切面(Aspect)、引入(Introduction)、
目标(target)、代理(proxy)、织入(weaving).
2.Spring AOP vs Full AspectJ
> Spring AOP相比FUll AspectJ简单，因为不需要将AspectJ编译器/weaving引入开发和构建过程，
如果只需要在Spring bean上执行操作，则选择Spring AOP；如果需要建议不受Spring容器管理的对象（例如域对象），
则需要使用AspectJ。如果您希望建议除简单方法执行之外的连接点（例如，字段获取或设置连接点等），则还需要使用AspectJ。
3. 代理机制.
> Spring AOP使用JDK动态代理或cglib为给定目标创建代理对象。如果目标对象至少实现了一个接口，
则使用JDK动态代理，如果目标对象未实现任何接口，则使用cglib代理。<br>
要强制使用CGLIB代理，请将元素proxy-target-class属性的值设置<aop:config>为true;
要在使用@AspectJ自动代理支持时强制CGLIB代理，请将元素的proxy-target-class属性设置 <aop:aspectj-autoproxy>为true.
