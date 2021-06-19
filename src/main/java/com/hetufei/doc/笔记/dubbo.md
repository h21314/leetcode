#### @Activate

Sharding-JDBC 复杂sql路由失败的问题，通过实现ParsingHook，


### 六、RPC框架
##### 1. RPC和http的区别，为什么要用rpc框架，为什么选用dubbo
##### 2.dubbo的总体架构，以及大体工作流程
##### 3.dubbo如何设置直连，一般用于本地测试
1、 文件映射（接口较多情况下）
2、consumer的<dubbo:reference>中配置url属性指向提供者地址
3、在consumer端的JVM启动参数中加入-D参数映射服务地址，如：(key为服务名，value为服务提供者url，此配置优先级最高)
  -Dcom.xxxxx.wms.sservice.WWhCommandService=dubbo://localhost:20890

##### 4.如何升级dubbo接口
dubbo提供接口服务多版本管理
##### 5.描述一下dubbo的spi机制
Dubbo 就依靠 SPI 机制实现了插件化功能，几乎将所有的功能组件做成基于 SPI 实现，并且默认提供了很多可以直接使用的扩展点，实现了面向功能进行拆分的对扩展开放的架构。
Java SPI源码分析
1、获取当前线程的ClassLoader。没有的话就用默认的SystemClassLoader
2、然后去定义好的目录下找文件，然后解析加载指定的类
3、创建类的实例
Java SPI缺点：
Java SPI 在查找扩展实现类的时候遍历 SPI 的配置文件并且将实现类全部实例化，假设一个实现类初始化过程比较消耗资源且耗时，但是你的代码里面又用不上它，这就产生了资源的浪费。
所以说 Java SPI 无法按需加载实现类。
DUBBO spi机制
Dubbo 就自己实现了一个 SPI，让我们想一下按需加载的话首先你得给个名字，通过名字去文件里面找到对应的实现类全限定名然后加载实例化即可。

Dubbo 就是这样设计的，配置文件里面存放的是键值对，我截一个 Cluster 的配置.
并且 Dubbo SPI 除了可以按需加载实现类之外，增加了 IOC 和 AOP 的特性，还有个自适应扩展机制。

我们先来看一下 Dubbo 对配置文件目录的约定，不同于 Java SPI ，Dubbo 分为了三类目录。
META-INF/services/ 目录：该目录下的 SPI 配置文件是为了用来兼容 Java SPI 。
META-INF/dubbo/ 目录：该目录存放用户自定义的 SPI 配置文件。
META-INF/dubbo/internal/ 目录：该目录存放 Dubbo 内部使用的 SPI 配置文件。
Adaptive 注解 - 自适应扩展
我们先来看一个场景，首先我们根据配置来进行 SPI 扩展的加载，但是我不想在启动的时候让扩展被加载，我想根据请求时候的参数来动态选择对应的扩展。

怎么做呢？

Dubbo 通过一个代理机制实现了自适应扩展，简单的说就是为你想扩展的接口生成一个代理类，可以通过JDK 或者 javassist 编译你生成的代理类代码，然后通过反射创建实例。

这个实例里面的实现会根据本来方法的请求参数得知需要的扩展类，然后通过 ExtensionLoader.getExtensionLoader(type.class).getExtension(从参数得来的name)，来获取真正的实例来调用。



##### 6.描述一下dubbo的服务暴露过程
> https://mp.weixin.qq.com/s/ISiN06QynyE2pPtX3cGQ9w
##### 7.描述一下dubbo服务引用的过程
> https://mp.weixin.qq.com/s/9oDy1OPcfDaEhKD4eNUdOA
##### 8.描述一下服务调用的过程
> https://mp.weixin.qq.com/s/oNR9v_ID2oAlEvDI93hRcw
##### 9. 为什么要封装成 invoker?
它也就代表一个可执行体，提供方和服务方都可用，至于为什么要封装成 invoker 其实就是想屏蔽调用的细节，统一暴露出一个可执行体，这样调用者简单的使用它，向它发起 invoke 调用，它有可能是一个本地的实现，也可能是一个远程的实现，也可能一个集群实现。
##### 10.为什么有本地协议？
存在一些服务既是服务提供方有事消费端，防止走网络通信
##### 11.DUBBO支持的协议和序列化协议有哪几种？
dubbo：单一长连接，传输数据量小，并发量高，使用hessian序列化协议
rmi协议：走java二进制序列化，多个短连接，适合消费者和提供者数量差不多，适用于文件的传输，一般较少用
hessian协议：多个短连接，适用于提供者数量比消费者数量还多，适用于文件的传输，一般较少用
http：走json序列化
webservice：走SOAP文本序列化
序列化协议：
dubbo 支持 hession、Java 二进制序列化、json、SOAP 文本序列化多种序列化协议。但是 hessian 是其默认的序列化协议。
##### 12.dubbo负载均衡策略
1、RandomLoadBalance；2、RoundRobinLoadBlance；3、LeastActiveLoadBlance；4、ConsistentHashLoadBalance

##### 13.dubbo三种调用方式
##### 14. zk有哪几种角色？
###### 一致性hash为了解决什么问题？
为了解决当有节点增加或删除时hash到其他位置上去了，造成大量的存储位置失效。
##### 16. dubbo容错策略
1、Failover Cluster。失败自动切换，当出现失败，重试其它服务器 。通常用于读操作，但重试会带来更长延迟。可通过 retries="2" 来设置重试次数(不含第一次)。
2、Failfast Cluster。快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
3、Failsafe Cluster、失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作
4、Failback Cluster 失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
5、Forking Cluster。并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
6、Broadcast Cluster。广播调用所有提供者，逐个调用，任意一台报错则报错 。通常用于通知所有提供者更新缓存或日志等本地资源信息
默认为Failover

##### 如何自己设计一个类似dubbo的rpc框架？
1、注册中心、高可用（nacos、consule、eruke、zk）
2、接着你就该发起一次请求了，咋发起？蒙圈了是吧。当然是基于动态代理了，你面向接口获取到一个动态代理，这个动态代理就是接口在本地的一个代理，然后这个代理会找到服务对应的机器地址。
3、然后找哪个机器发送请求？那肯定得有个负载均衡算法了，比如最简单的可以随机轮询是不是
4、网络通信：接着找到一台机器，就可以跟他发送请求了，第一个问题咋发送？你可以说用netty了，nio方式
5、序列化：hessian序列化协议了，或者是别的，对吧。然后请求过去了。
6、指定协议，使用http、dubbo协议。

##### 当⼀个服务接⼝有多种实现时怎么做？
当⼀个接⼝有多种实现时，可以⽤ group 属性来分组，服务提供⽅和消费⽅都指定同⼀个 group 即可。

##### spi做了什么操作
DubboAccessLogFilter，重写AccessLogFilter
DubboExceptionFilter 处理dubbo异常
CorpShardingFilter
//这个不是SPI机制，是spring.factory机制，可以自动配置starter
EnableAutoConfiguration = com.tenwit.common.autoconfigure.TenwitFileAutoConfiguration
配合条件注解注入不同的文件上传类：
BaseFileService、ExclusiveBaseFileService

Java SPI机制应用
ShardingDataAesEncryptor
LeafSegmentShardingKeyGenerator
LeafSnowflakeShardingKeyGenerator
ComplexSqlParsingHook
DbShardingKeyContextRoutingHook