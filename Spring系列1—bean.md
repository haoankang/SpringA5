## 1. 一些基本知识.
1. bean的命名规则.
> 一般而言，bean命名优先级id——>name——>alias——>缺省名称；如果有多个，均指向同一个bean；
2. 实例化bean的三种方式.
> a. 构造函数实例化. b. 使用静态工厂方法实例化. c. 使用实例工厂方法实例化.
3. 依赖注入.
> 依赖注入两种方式. a. 基于构造函数的依赖注入. b. 基于setter的依赖注入.<p>
  其他相关：依赖depend-on，lazy-init，autowire和autowire-candidate.
  重点lookup-method，查找方法注入，可以用来处理单例中引入原型scope.