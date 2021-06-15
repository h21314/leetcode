##### 1. synchronized原理
代码块，锁对象的话：monitorEnter、monitorExit
方法：ACC_SYNCHROINZED

##### 2.锁的优化升级
无锁 -> 偏向锁 -> 轻量级锁 -> 重量级锁，还有锁消除、锁膨胀
##### 3.锁的对象头包含的内容
对象包含的数据有对象头，实例数据，对齐填充
对象头里有markword、类元数据；
而MARKWORD中又存了对象的HashCode、分代年龄、锁标记位、偏向线程ID，偏向时间戳

##### 4、ReentrantLock的原理以及与synchronized的区别
AQS框架，持有一个volatile修饰的state变量，一个是API，一个jvm层面，支持非公平、公平锁，需要手动释放，可以设置超时时间
##### 5、AQS原理
aqs内部持有一个volatile修饰的state变量，以及两个队列，一个同步队列，一个条件队列。
同步队列作用：当线程获取资源失败后，会加入同步队列的尾部保持自旋等待，不断判断自己是否是链表的头结点，如果是头结点，就不断获取资源，获取成功后退出同步队列。
条件队列作用：是Lock实现的一个基础同步器，并且一个线程可能会有多个条件队列，只有在使用了Condition才会存在条件队列。
同步队列和条件队列都是由一个个Node节点组成。

##### 6、CAS原理以及缺点，ABA问题如何解决
cas优点：如一描述在并发量不是很高时cas机制会提高效率。
cas缺点：
1、cpu开销大，在高并发下，许多线程，更新一变量，多次更新不成功，循环反复，给cpu带来大量压力。
2、只是一个变量的原子性操作，不能保证代码块的原子性。
加版本号可以解决
##### 7. volatile原理
可见性，强制主内存的变量刷新到工作内存
禁止指令重排序，生成指令后会插入内存屏障，
读：前面LoadLoad、后面加LoadStore
写：前端StoreStore，后面加StoreLoad

##### 为什么要有内存屏障？
为了解决cpu、高速缓存与主内存之间带来的指令之间的可见性和重序性问题。
每个cpu都会有自己的缓存（L1,L2,L3），缓存的目的是为了提高性能，但这样也会造成不能实时和内存发生信息交换，会使得不同cpu执行的不同线程对同一个变量的缓存值不同。
Load屏障：对应x86上的ifence指令，在其他指令前插入ifence指令，可以让高速缓存中的的数据失效，强制当前线程从主内存中加载数据。
Store屏障：对应x86上的sfence指令，在其他指令后插入sfence指令。可以让当前线程写入告诉缓存中的最新数据，写入主内存，让其他线程可见。
LoadLoad屏障：举例语句是Load1; LoadLoad; Load2(这句里面的LoadLoad里面的第一个Load对应Load1加载代码，然后LoadLoad里面的第二个Load对应Load2加载代码)，此时的意思就是，在Load2及后续读取操作从内存读取数据到CPU前，保证Load1从主内存里要读取的数据读取完毕。

StoreStore屏障：举例语句是 Store1; StoreStore; Store2(这句里面的StoreStore里面的第一个Store对应Store1存储代码，然后StoreStore里面的第二个Store对应Store2存储代码)。此时的意思就是在Store2及后续写入操作执行前，保证Store1的写入操作已经把数据写入到主内存里面，确认Store1的写入操作对其它处理器可见。

LoadStore屏障：举例语句是 Load1; LoadStore; Store2(这句里面的LoadStore里面的Load对应Load1加载代码，然后LoadStore里面的Store对应Store2存储代码)，此时的意思就是在Store2及后续代码写入操作执行前，保证Load1从主内存里要读取的数据读取完毕。

StoreLoad屏障：举例语句是Store1; StoreLoad; Load2(这句里面的StoreLoad里面的Store对应Store1存储代码，然后StoreLoad里面的Load对应Load2加载代码)，在Load2及后续读取操作从内存读取数据到CPU前，保证Store1的写入操作已经把数据写入到主内存里，确认Store1的写入操作对其它处理器可见。
原文链接：https://blog.csdn.net/qq_35091353/article/details/116354734

##### 8. jmm内存模型
主内存 -> 工作内存模型

##### 9.CountDownLatch、CycleBarrier、Semaphore区别
计数器（主线程等其他线程完成后再执行），栅栏（所有线程统一执行到一个点，等待，然后再一起执行），信号量（控制线程数）
##### 10.什么是Happen-before以及as-if-seraial
as-if-serial:在单线程下执行结果不会改变。
##### 11.什么是逃逸分析

##### 12.ThrealLocal原理以及应用场景
ThreadLocal类用来提供线程内部的局部变量。这种变量在多线程环境下访问（通过get和set方法访问）时能保证 各个线程的变量相对独立于其他线程内的变量。ThreadLocal实例通常来说都是private static类型的，用于关联线程和线程上下文。
ThreadLocal方案的好处
数据传递 ： 保存每个线程绑定的数据，在需要的地方可以直接获取, 避免参数直接传递带来的代码耦合

线程隔离 ： 各线程之间的数据相互隔离却又具备并发性，避免同步方式带来的性能损失。
每一个Thread线程，单独维护一个ThreadLocalMap，这个对应Map的key为ThreadLocal实例本身，value为我们需要存储的值，是一个Object类型。

为什么使用弱引用？
因为使用弱引用不会影响ThreadLocal对象被释放后的垃圾回收，由于使用了弱引用，
被释放的对象只能存活到下一次gc，对象被回收后弱引用就变为null，这时候就可以进行判断这个位置的条目是否已经是旧条目，
从而进行清理。防止内存泄漏，

##### 13.线程池原理，以及在正式开发中如何使用（自定义线程池，带名字，方便排查，线程池的参数如何设置），如何避免内存泄漏的问题。线程池的拒绝策略。如何自己实现拒绝策略
为什么先放队列里而不是先创建线程直到最大线程数？
在创建新线程的时候，是要获取全局锁的，这个时候其它的就得阻塞，影响了整体效率。
|

fixed：corePoolSize = maximumPoolSize，LinkedBlockingQueuesingled： coolPoolSize = maximumPoolSize = 1，BlockingQueue
newCachedThreadPool： coolPoolSize = 0，maximumPoolSize=Integer.Max_value,KeepAliveTime = 60L,SynchronousQueue
newScheduledThreadPool coolPoolSize等于传入的值，maximumPoolSize=INTEGER.MAX_VALUE
##### 14. 强软弱虚四种引用的区别
软：空间足够不会回收，不够就会回收，软引用可用来实现内存敏感的高速缓存
弱：不够够不够都会回收，弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
虚：虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列（ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之 关联的引用队列中。

##### 15.有哪些阻塞队列以及非阻塞队列
阻塞队列：ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue、PriorityBlockingQueue、DelayQueue
非阻塞队列：ConcurrentLinkedQueue、LinkedTransferQueue
##### 16. 类加载的机制，双亲委派机制的好处，以及如何打破双亲委派机制。哪些中间件或者框架打破了双亲委派机制
BootStrapClassLoader、ExtClassLoader、ApplicationClassLoader。
1、加载，通过类名获取二进制字节流，将字节流代表的静态存储结构转化为方法去的运行时数据结构，在内存中生成对象，作为方法去这个类的各种数据的访问入口。
2.验证，确保被加载的类的安全性
3.准备，为类的静态变量分配内存，并将其赋默认值
4、解析，常量池中的符号引用替换为直接引用。 符号引用就是一组符号来描述目标，可以是任何字面量。属于编译原理方面的概念如：包括类和接口的全限定名、字段的名称和描述符、方法的名称和描述符。直接引用就是直接指向目标的指针、相对偏移量或一个间接定位到目标的句柄。如指向方法区某个类的一个指针
5、初始化：为类的静态变量赋值。
6.使用
7.卸载
参考文章：https://blog.csdn.net/zhaocuit/article/details/93038538
##### 17.JVM内存模型，哪些区域是线程共享的，哪些是线程私有的
堆共享，pc、本地方法栈，虚拟机栈是线程私有的，方法区共享（静态变量和常量在方法区）
##### 18. JVM如何判定对象是否需要被回收
引用计数法、可达性分析
##### 19.哪些对象可作为gcroot?
- 虚拟机栈中引用的对象
- 方法区中静态属性、常量引用的变量（static、final修饰的变量）
- 本地方法栈中JNDI引用的对象



##### 20.常见的垃圾回收算法，以及分代回收的流程
标志清除，内存碎片
复制 内存空间利用不足
标记整理 ，效率低
分代回收：
新生代：复制
老年代：标记-整理
新生代：老年代 = 1:2
##### 21.哪些常用的垃圾回收器，分别有什么区别
 > CMS和G1的区别
- 使用范围：CMS使用在老年代，可以配合新生代的serial和parNew收集器一起使用；G1的使用范围是老年代和新生代。不需要结合其他收集器使用。
- STW时间：CMS以最小的停顿时间为目标；G1可以预测垃圾回收的停顿时间（建立可预测的停顿时间模型）
- 垃圾碎片：CMS收集器使用标记-清除算法，容易产生内存碎片；G1使用标记-整理算法，还可以划分区域进行按区回收，降低了内存空间碎片。
- 垃圾回收过程：
CMS:1.初始标记；2.并发标记；3.重新标记；4：并发清除
G1： 1.初始标记；2：并发标记：3：最终标记：4、筛选回收

##### 22.常见的JVM参数配置
-Xms 初始堆的大小，默认为物理内存的1/64
-Xmx 最大堆大小，默认为物理内存的1/4
-Xmn 年轻代大小（1.4版本或之后的版本）。（整个堆=年轻代+老年代+持久代（1.8后移除了永久代，改为在直接内存上分配元空间））
-XX:NewSize (1.3/1.4版本)
-XX:MaxNewSize	年轻代最大值(for 1.3/1.4)
-XX:PermSize 设置持久代(perm gen)初始值
-Xss 每个线程的堆栈大小。如果栈不是很深， 应该是128k够用的 大的应用建议使用256k。这个选项对性能影响比较大，需要严格的测试。（校长）
-XX:NewRatio 年轻代与老年代的比值
-XX:SurvivorRatio Eden区和Survivor区的比值
-XX:+UseParNewGC 设置年轻代为并行收集，可与CMS同事使用
-XX:+UseParallelOldGC 年老代垃圾收集方式为并行收集(Parallel Compacting)
-XX:+ScavengeBeforeFullGC Full GC前调用YGC
-XX:+PrintGC
-XX:+PrintGCDetails
 -XX:+HeapDumpOnOutOfMemoryError
##### 23. cpu过高如何排查
top -hp -> jstack -> 找出堆栈信息
##### 24.内存溢出如何排查，栈内存溢出如何排查，死锁如何排查，以及如何破坏死锁
-> jvm参数设置，或者手动jmap -dump:live,format=b,file=myjmapfile.txt 19570 命令，然后使用mat工具
##### 25. 频繁发生FullGC如何排查
拿到dump日志
旧生代空间不足。
Permanet Generation空间满了(1.8后取消了永久代，改为元空间，使用直接内存)
通过Minor GC后进入老年代的平均大小大于老年代的可用内存
由Eden区、From Space区向To Space区复制时，对象大小大于To Space可用内存，则把该对象转存到老年代，且老年代可用内存不足(老年代可用内存小于该对象)

##### 26.垃圾回收底层原理

##### 27.有哪些常用的JVM问题排查工具



##### 28.栈桢

##### 29. TLAB问题

##### 30. 什么时候进行FullGC，什么时候进行YGC，对象什么时候进入老年代，什么是分配担保机制？
Fullgc：Permanet Generation空间满了，老年代空间不足，通过Minor GC后进入老年代的平均大小大于老年代的可用内存，systen.gc
ygc:edn空间不足

##### 31 线程池在使用过程中遇到过什么问题？
线程池未命名、不允许通过Executors创建、线程池隔离
##### 32 对象的创建过程
##### forkjoin
##### 线程池为什么要先放到队列中去而不是先创建线程以满足最大线程数
1、降低资源消耗，提升线程的利用率，降低创建和销毁线程的消耗；
2、线程池创建线程需要获取mainLock全局锁，影响并发效率，所以使用阻塞队列把第一步创建核心线程与第三部创建最大线程隔离开来，起一个缓冲的作用。
3、引入阻塞队列，是为了在执行execute方法时，尽可能的避免获取全局锁

##### 如何设置线程数，线程数怎么取值比较好？
获取cpu核数：Runtime.getRuntime().availableProcessors()
1、cpu密集型：cpu核数+ 1。
2、IO密集型：cpu*2


### jvm的分代年龄为什么是15？
原因是在对象的Markword中
对象的HashCode占25Bit，对象的分代年龄占4Bit，是否为偏向锁标志占1Bit，锁标志占2Bit
因为分代年龄占4位，所以最大值为1111，转为十进制则为15

### 依据什么来设置参数大小？
arthas是一款线上诊断工具，功能非常强大，使用命令行交互模式。

### 有什么好用的内存分析工具？
