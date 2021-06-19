### 七、Spring以及SpringCloud
##### 1. 描述一下IOc和aop，为什么要使用ioc，aop原理
ioc通过spring容器来负责对bean的加载；
aop通过动态代理来实现
##### 2. 描述一下循环依赖以及spring是如何解决循环依赖的
> 使用三级缓存，https://www.jianshu.com/p/8bb67ca11831
##### 3.描述一下bean的生命周期
> https://yemengying.com/2016/07/14/spring-bean-life-cycle/
##### 4.Spring的容器启动流程
1、资源定位：找到配置文件   
2、BeanDefinition载入和解析   
3、BeanDefinition注册   
4、bean的实例化和依赖注入
1、BeanDefinition载入、解析、注册
1、找到配置文件Resource。   
2、将配置文件解析成BeanDefinition   
3、将BeanDefinition向Map中注册   Map<name,beandefinition>
##### 5.Spring事务的隔离级别以及传播行为
隔离级别一共五种，加上default
Propagation.REQUIRED：如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。
Propagation.SUPPORTS：如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。
Propagation.MANDATORY：如果当前存在事务，则加入该事务；如果当前不存在事务，则抛出异常。
Propagation.REQUIRES_NEW：重新创建一个新的事务，如果当前存在事务，延缓当前的事务。
Propagation.NOT_SUPPORTED：以非事务的方式运行，如果当前存在事务，暂停当前的事务。
Propagation.NEVER:以非事务的方式运行，如果当前存在事务，则抛出异常。
Propagation.NESTED：如果没有，就新建一个事务；如果有，就在当前事务中嵌套其他事务。

##### 6.Bean的socpe
> prototype,singleton,request、session、global session
##### 7.Springboot自动装配原理，以及如何自定义一个starter
> @springBootApplicaiton -> @EnableAutoConfighurtion -> Meta-info/SPRING.FACTORY文件下
##### 8.条件注解
##### 9.springcloud常用组件
##### 10.nacos健康检查，原理，常见的注册中心有哪几个，区别是什么，为什么选用nacos
##### 11.熔断、限流、降级、监控系统、网关、权限、日志，日志是如何进行采集上报的。有哪几种限流算法
##### gateway路由配置，以及和zuul的区别
##### 为什么使用bff层，如何分层，讲一下领域模型
##### 讲一下项目的架构图
##### ribon负载均衡有哪几种策略
> RoundRobinRule轮询（默认）、RandomRule随机、RetryRule轮询重试（重试采用的默认也是轮询）、WeightedResponseTimeRule响应速度决定权重：BestAvailableRule最优可用、AvailabilityFilteringRule
 ZoneAvoidanceRule
##### 柔性事务（最大努力送达型事务、TCC 事务）
CP：牺牲可用性。复制同步的协议一般使用严格的法定数协议 (Paxos、Raft、ZAB)或者2PC协议。CP类型的系统有MongoDB、HBase、 Zookeeper、Redis等。
AP：牺牲一致性。复制同步的协议一般使用非严格的法定数协议。AP类型的系统有 Couch DB、Cassandra、Amazon Dynamo等

https://blog.csdn.net/wsdc0521/article/details/108223310
##### 讲一下你了解的分库分表中间件的底层实现原理?
##### 熔断机制