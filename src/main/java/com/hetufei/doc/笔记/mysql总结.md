### 1.innodb和myisaim区别
> 事务、行锁，外键、聚集索引，非聚集索引
##### 2.为什么使用b+树索引，索引结构，与b树的区别是
b+树只有叶子节点存数据，b+树查询效率比较稳定。b+树每页能存更多的索引，b树非叶子节点也会存储数据。
##### 3.事务的隔离级别，不同的隔离级别可能存在的问题，以及如何解决
读未提交 不会使用到mvcc机制
读已提交 会使用到mvcc机制，select时每个事物读的都是最新的Read view
可重复读 会使用mvcc机制，select时对每个事物都会开启一个Readview，每个事物读的都是自己的那个视图
串行化

##### 持久性的原理，redo日志
##### mvcc多版本控制，
> 只在读以提交和可重复读生效，读已提交：每一次select时都会生成一个视图；可重复读：第一次select时生成一个view，后续select都用这个view。
mvcc会在每一行上都生成两个隐藏列trx_id，roll_pointer；

参考文章：https://blog.csdn.net/SnailMann/article/details/94724197
##### 出现慢sql如何排查
##### 索引优化
##### explain各个字段的含义
##### 如何保证mysql的高可用，
> 主备、读写分离
>
##### 分库分表实现方案
垂直、水平
##### 数据库锁有哪几种
乐观锁、悲观锁、
页锁，表锁，行锁、间隙锁、next key lock = 间隙锁 + 行锁
##### 如何设计动态扩容的分库分表方案
> 停机扩容（不推荐）倍数扩容
>
##### 采用分库分表后历史数据如何迁移
> 编写程序同步历史数据，再利用mq进行双写操作
##### 用过哪些分库分表中间件,有啥优点和缺点,
##### 分片策略
- 标准分片策略（StandardShardingStrategy）它只支持对单个分片健（字段）为依据的分库分表，并提供了两种分片算法 PreciseShardingAlgorithm（精准分片）和 RangeShardingAlgorithm（范围分片）。
- 复合分片策略、SQL 语句中有>，>=, <=，<，=，IN 和 BETWEEN AND 等操作符，不同的是复合分片策略支持对多个分片健操作，自定义复合分片策略要实现 ComplexKeysShardingAlgorithm 接口，重新 doSharding()方法。

- 行表达式分片策略（InlineShardingStrategy）提供对 SQL语句中的 = 和 IN 的分片操作支持，它只支持单分片健。行表达式分片策略适用于做简单的分片算法，无需自定义分片算法，省去了繁琐的代码开发，是几种分片策略中最为简单的
- Hint分片策略 
> Hint分片策略（HintShardingStrategy）相比于上面几种分片策略稍有不同，这种分片策略无需配置分片健，分片健值也不再从 SQL中解析，而是由外部指定分片信息，让 SQL在指定的分库、分表中执行。ShardingSphere 通过 Hint API实现指定操作，实际上就是把分片规则tablerule 、databaserule由集中配置变成了个性化配置。
           举个例子，如果我们希望订单表t_order用 user_id 做分片健进行分库分表，但是 t_order 表中却没有 user_id 这个字段，这时可以通过 Hint API 在外部手动指定分片健或分片库。


##### 聚簇索引和唯一索引区别
##### redolog undolog binlog区别
redo log是InnoDB存储引擎层的日志，又称重做日志文件，用于记录事务操作的变化，记录的是数据修改之后的值，不管事务是否提交都会记录下来。在实例和介质失败（media failure）时，redo log文件就能派上用场，如数据库掉电，InnoDB存储引擎会使用redo log恢复到掉电前的时刻，以此来保证数据的完整性。

在一条更新语句进行执行的时候，InnoDB引擎会把更新记录写到redo log日志中，然后更新内存，此时算是语句执行完了，然后在空闲的时候或者是按照设定的更新策略将redo log中的内容更新到磁盘中，这里涉及到WAL即Write Ahead logging技术，他的关键点是先写日志，再写磁盘。

有了redo log日志，那么在数据库进行异常重启的时候，可以根据redo log日志进行恢复，也就达到了crash-safe。

redo log日志的大小是固定的，即记录满了以后就从头循环写。

### mysql update语句执行流程
``
 UPDATE T SET age = age+1 WHERE id = 1;
``
1、客户端通过连接器与mysql相连。
2、删除要update表的缓存
3、mysql分析器解析sql并判断是否含有语句错误
4、优化器确定查询索引
5、执行器先找引擎找id=1这行记录。id为主键，引擎通过索引找到记录.(判断数据是否在内存中，在的话直接返回行数据，不在的话从磁盘中读取数据到内存中（读取一整页）)
6、执行器拿到行记录，对age+1，调用引擎写接口，更新数据；
7、引擎将新记录更新到内存，并将更新记录写入redo log，redo log处于prepare状态，随时可以提交事务；
10，执行器生成bin log写入磁盘；
11，执行器调用引擎提交事务接口，把redo log成成commit状态，更新完成。

innodb_flush_log_at_trx_commit设置为1，表示每次事务的redo log都直接持久化到磁盘，可以保证MySQL异常重启之后数据不丢失。

sync_binlog设置为1，表示每次事务的bin log都持久化到磁盘，可以保证MySQL异常重启之后bin log不丢失。
三、二阶段提交
为了让两份日志逻辑一致，上述操作使用了二阶段提交。

假设不使用二阶段提交，会有如下两种情况。

假设age = 10，使用之前的UPDATE SQL。

A.先写redo log，后写bin log；中间发生崩溃，通过redo log自动恢复数据，age = 11。但是因为bin log没有写入，如果用之前的数据进行恢复，age = 10。

B.先写bin log，后写redo log；中间发生崩溃，age = 10（未更新），使用bin log恢复，age = 11。

都会出现数据不一致的情况，使用二阶段提交，让两份日志数据保持逻辑上的一致。

为什么要使用二阶段提交？
答：反证法。
1、先写redo log后写binlog。假设redo log写完，binlog还没写完，mysql进程异常重启。由于我们前面说过的，redo log写完之后，系统及时崩溃了，仍然能够恢复数据。但由于binlog没写成功就crash了，这时候binlog里面就没有记录这个语句。因此，之后备份日志的时候，然后你会发现，当需要用这个binlog日志来恢复数据时，由于这个binlog丢失，这个临时库就会少了这一次更新，导致数据丢失。
2、先写binlog再写redo log。如果在binlog写完之后crash，由于redo log还没写，崩溃恢复之后这个事务无效，所以这一行c的值是0
；但是binlog里面已经记录了将c从0改为1的这条日志，所以，后序用binlog恢复的时候就多了一个事务出来，恢复后的数据就是1，与原库的值不同。
redo log和binlog都可以用于表示事务的提交状态，而两阶段提交就是让这两个状态保持逻辑上的一致。

具体update语句更新流程以及使用二阶段提交保证redo log和binlog日志保持逻辑上的一致相关知识可以参照
https://www.jianshu.com/p/c852253fd443



### MySql事务日志redo log和undo log区别
数据库存放数据的文件成为data file，日志文件称为log file；数据库数据是由缓存的，数据库缓存称为data buffer；日志缓存称为log buffer；既然存在缓存，就很难保证缓存数据与磁盘数据的一致性。
存储引擎会为redo undo日志开辟内存缓存空间（log buffer）。磁盘上的日志文件称为log file。是顺序追加的，性能很高。
undo 日志用于记录事务开始前的状态，用于事务失败时的回滚。redo日志记录事务执行后的状态，用来恢复未写入data file的已成功的事务更新数据。
以下是事务执行的各个阶段：
1、写undo日志到log buffer
2、执行事务，并写redo日志到log buffer
3、如果innodb_flush_log_at_trx_commit = 1则将redo日志写到log file，并刷新磁盘
4、提交事务。
可能有同学会问，为什么没有写data file，事务就提交了？

在数据库的世界里，数据从来都不重要，日志才是最重要的，有了日志就有了一切。

 因为data buffer中的数据会在合适的时间 由存储引擎写入到data file，如果在写入之前，数据库宕机了，根据落盘的redo日志，完全可以将事务更改的数据恢复。好了，看出日志的重要性了吧。先持久化日志的策略叫做Write Ahead Log，即预写日志。

分析几种异常情况：

innodb_flush_log_at_trx_commit=2（innodb_flush_log_at_trx_commit和sync_binlog参数详解）时，将redo日志写入logfile后，为提升事务执行的性能，存储引擎并没有调用文件系统的sync操作，将日志落盘。如果此时宕机了，那么未落盘redo日志事务的数据是无法保证一致性的。
undo日志同样存在未落盘的情况，可能出现无法回滚的情况。
checkpoint：

 checkpoint是为了定期将db buffer的内容刷新到data file。当遇到内存不足、db buffer已满等情况时，需要将db buffer中的内容/部分内容（特别是脏数据）转储到data file中。在转储时，会记录checkpoint发生的”时刻“。在故障回复时候，只需要redo/undo最近的一次checkpoint之后的操作。
 
 ### redo log 和binlog日志的区别
 - binlog是在存储引擎的上层产生的，不管是什么存储引擎，只要对数据库进行了修改都会产生binlog日志。而redo log是innodb层产生的，只记录该存储引擎中表的修改。并且二进制文件先于redo log被记录。
 - binlog记录逻辑性的语句。即它是基于行格式的记录方式，其本质是逻辑的sql设置。而redo log是在物理格式上的日志，记录的是数据库中每个页的修改
 - binlog只在每次事务提交时一次性写入缓存中的日志文件。而redo log在事物中就会产生，并且在数据真正修改前先写入缓存中的redo log，然后才对内存中的数据执行修改操作；而且保证在事物提交时，先向缓存中的redo log写入到redo log file
 中，redo log file写入完成后才执行提交动作。
 - 因为binlog只在提交时一次性写入，所以binlog日志中记录方式和提交顺序有关，且一次提交对应一次记录。而redo log是记录的物理页的修改，redo log file中同一个事物可能多次记录，最后一个提交的事务会覆盖所有未提交的事务记录。
 例如事务T1，可能在redo log中记录了 T1-1,T1- 2,T1-3，T1* 共4个操作，其中 T1* 表示最后提交时的日志记录，所以对应的数据页最终状态是 T1* 对应的操作结果。而且redo log是并发写入的，不同事务之间的不同版本的记录会穿插写入到redo log文件中，例如可能redo log的记录方式如下： T1-1,T1-2,T2-1,T2- 2,T2,T1-3,T1 。

redo log用来保证事务的持久性。redo log可以分为物理redo 日志和逻辑redo 日志。在InnoDB存储引擎中，大部分情况下 Redo是物理日志，记录的是数据页的物理变化。
逻辑Redo日志，不记录页面的实际修改内容，而只记录修改页面的一类操作，比如新建数据页。关于逻辑Redo日志涉及更加底层的内容，这里我们只需要记住绝大数情况下，Redo是物理日志即可，DML对页的修改操作，均需要记录Redo。

redo的主要作用是用于数据库的崩溃恢复
#### redo组成：
redo log buffer 在内存中，易失
redo log file 在磁盘中，是持久性的。


### .MySQL间隙锁为了解决什么问题，什么条件下会触发?

### 幻读因为什么造成的?

### mysql的数据页空洞是怎么造成的，如果解决，索引是局部还是全局的

### mysql如果发生了抖动，怎么排查问题?

