##1. Resource的一些基本知识.
1. Spring定义了一个统一资源接口Resource用于访问各种资源.
2. 内置的一些资源实现.
> 包括以下：UrlResource. ClassPathResource. FileSystemResource. ServletContextResource. InputStreamResource. ByteArrayResource.
<p>
3. ResourceLoader接口可以返回Resource实例的对象实现.
4. ResourceLoaderAware接口.

##2. 验证、数据绑定和类型转换.

##3. SpEL表达式.
SpEL提供简单的接口从而简化用户使用，在介绍原理前让我们学习下几个概念：

   一、表达式：表达式是表达式语言的核心，所以表达式语言都是围绕表达式进行的，从我们角度来看是“干什么”；

   二、解析器：用于将字符串表达式解析为表达式对象，从我们角度来看是“谁来干”；

   三、上下文：表达式对象执行的环境，该环境可能定义变量、定义自定义函数、提供类型转换等等，从我们角度看是“在哪干”；

   四、根对象及活动上下文对象：根对象是默认的活动上下文对象，活动上下文对象表示了当前表达式操作的对象，从我们角度看是“对谁干”。

原理：
    
    1）首先定义表达式：“1+2”；
    
    2）定义解析器ExpressionParser实现，SpEL提供默认实现SpelExpressionParser；
    
    2.1）SpelExpressionParser解析器内部使用Tokenizer类进行词法分析，即把字符串流分析为记号流，记号在SpEL使用Token类来表示；
    
    2.2）有了记号流后，解析器便可根据记号流生成内部抽象语法树；在SpEL中语法树节点由SpelNode接口实现代表：如OpPlus表示加操作节点、IntLiteral表示int型字面量节点；使用SpelNodel实现组成了抽象语法树；
    
    2.3）对外提供Expression接口来简化表示抽象语法树，从而隐藏内部实现细节，并提供getValue简单方法用于获取表达式值；SpEL提供默认实现为SpelExpression；
    
    3）定义表达式上下文对象（可选），SpEL使用EvaluationContext接口表示上下文对象，用于设置根对象、自定义变量、自定义函数、类型转换器等，SpEL提供默认实现StandardEvaluationContext；
    
    4）使用表达式对象根据上下文对象（可选）求值（调用表达式对象的getValue方法）获得结果。