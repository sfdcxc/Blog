# Redis学习
@author:Darcy

## 入门
### 数据类型
1. 获得符合规则的键名列表
	- KEYS pattern
	- ![](https://i.imgur.com/8JqOOKS.png)
2. 判断一个键是否存在,存在返回整数类型1，否则返回0
	- EXISTS key
3. 删除键, 返回值是删除键的个数
	- DEL key
4. 获取键值的数据类型,返回值可能是string,hash,list,set,zset
	- TYPE key

### 字符串类型
- 介绍
	- 是Redis最基本的数据类型，能存储任何形式的字符串，包括二进制数据。允许存储的数据的最大容量是512MB
	- 字符串类型是其他4种数据类型的基础
- 命令
	1. 赋值与取值
		- SET key value
		- GET key
	2. 递增数字
		- INCR key
	3. 增加指定的整数
		- INCRBY key increment
	4. 减少指定的整数
		- DECRBY key decrement
	5. 增加指定浮点数
		- INCRBYFLOAT key increment
	6. 向尾部追加值，返回指是追加后字符串的总长度
		- APPEND key value
	7. 获取字符串长度，键不存在返回0
		- STRLEN key
	8. 同时获得/设置多个键值
		- MGET key [key..]
	9. 位操作
		- GETBIT key offset
		- SETBIT key offset value
		- BITCOUNT key [start] [end]
		- BITOP operation destkey key [key..]

### 散列类型
- 介绍
	- 散列类型(hash)的键值是一种字典结构，存储了字段(field)和字段值的映射，字段值只能是字符串
- 命令
	1. 赋值与取值
		- HSET key field value
		- HGET key field
		- HMSET key field value [field value ..]
		- HMGET key field [field]
		- HGETALL key
		- HSET 命令方便之处在于不区分插入和更新操作，插入操作时HSET返回1，更新操作时HSET命令返回0，当键不存在时，HSET命令会自动建立它
	2. 判断字段是否存在
		- HEXISTS key field	存在返回1， 否则返回0
	3. 字段不存在时赋值 与HSET类似
		- HSETNX key field value
	4. 增加数字
		- HINCRBY key field increment
	5. 删除字段
		- HDEL key field [field ..]
- 命令拾遗
	1. 只获取字段名或字段值
		- HKEYS key
		- HVALS key
	2. 获得字段数量
		- HLEN key

### 列表类型
- 介绍
	- 可以存储一个有序的字符串列表，常用的操作是向列表两端添加元素，或者获取列表的某一个片段
	- 内部使用双向链表实现
- 命令
	1. 向列表两端增加元素
		- 向列表左边添加， 返回值表示元素后列表的长度
			- LPUSH key value [value ..]
		- 向列表左边添加， 返回值表示元素后列表的长度
			- RPUSH key value [value ..]
	2. 向列表两端弹出元素
		- LPOP key
		- RPOP key
	3. 获取列表元素的个数, 键不存在时会返回0
		- LLEN key
	4. 获取列表片段
		- LRANGE key start stop
	5. 删除列表中指定的值
		- LREM key count value
		- LREM 会删除列表中前count个值为value元素，返回值是实际删除的元素个数
- 命令拾遗
	1. 获取/设置指定索引的元素值
		- LINDEX key index
		- LSET key index value
	2. 只保留列表指定片段
		- LTRIM key start end
	3. 向列表中插入元素
	4. 将元素从一个列表转到另一个列表

### 集合类型
- 介绍
	- 集合中每个元素都是不同的，且没有顺序
	- ![](https://i.imgur.com/0VQb4ZV.png)
- 命令
	1. 增加/删除元素
		- SADD key member [number ..]
		- SREM key member [number ..]
		- 返回值是成功加入的元素数量
	2. 获得集合中的所有元素
		- SMEMBERS key
	3. 判断元素是否在集合中， 存在SISMEMBER命令返回1， 值不存在或键不存在时返回0
		- STSMEMBER key member
	4. 集合间运算
		- SDIFF key [key ..]
			- 对多个集合执行差集运算
		- SINTER key [key ..]
			- 对多个集合执行交集运算
		- SUNION key [key ..]
			- 对多个集合执行并集运算
- 命令拾遗
	1. 获得集合中元素个数
		- SCARD key
	2. 进行集合运算并将结构存储
		- SDIFFSTORE destination key [key ..]
		- SINTERSTORE destination key [key ..]
		- SUNIONSTORE destination key [key ..]
	3. 随机获得集合中的元素
		- SANDMEMBER key [count]
	4. 从集合中弹出一个元素
		- SPOP key

### 有序集合类型
- 介绍
	- 在集合类型的基础上有序集合类型为集合中的每个元素都关联了一个分数，除了集合基本操作，还能狗获得分数最高(或最低)的前N个元素
- 命令
	1. 增加元素
		- ZADD key score member [score member..]
		- 向有序集合中加入一个元素与该元素的分数，存在则用新的分数替换原有的分数
	2. 获得元素的分数
		- ZSCORE key member
	3. 获得排名在某个范围的元素列表
		- ZRANGE key start stop [WITHSCORES]
		- ZREVERANGE key start stop [WITHSCORES]
	4. 获得指定分数范围的元素
		- ZRANGEBYSCORE key min max
	5. 增加某个元素的分数
		- ZINCRBY scoreboard 4 Jerry
- 命令拾遗
	1. 获得集合中元素的数量
		- ZCARD key
	2. 获得指定分数范围内的元素个数
		- ZCOUNT key min max
	3. 删除一个或多个元素
		- ZREM key member [member..]
	4. 按照排名范围删除元素
		- ZREMRANGEBYRANK key start stop
	5. 按照分数范围删除元素
		- ZREMRANGEBYSCORE key min max
	6. 获得元素的排名
		- ZRANK key member
		- ZREVERANK key member
	7. 计算有序集合的交集
		- ZINTERSTORE destination numkeys key [key ..] [WEIGHTS [weight..]][AGGREGATE SUM|MIN|MAX]