# mongoDb 基础知识

### 与关系型数据库的对比

| SQL概念     | MongoDB概念 | 解释/说明                           |
| ----------- | ----------- | ----------------------------------- |
| database    | database    | 数据库                              |
| table       | collection  | 数据库表/集合                       |
| row         | document    | 数据记录行/文档                     |
| column      | field       | 数据字段/域                         |
| index       | index       | 索引                                |
| primary key | primary key | 主键,MongoDB自动将_id字段设置为主键 |



### 数据类型

Object ID ：Documents 自生成的 _id

String： 字符串，必须是utf-8

Boolean：布尔值，true 或者false

Integer：整数 (Int32 Int64 你们就知道有个Int就行了,一般我们用Int32)

NumberDecimal： 一般用于货币处理

Double：浮点数 (没有float类型,所有小数都是Double)

Arrays：数组或者列表，多个值存储到一个键 

Object：字典

Null：空数据类型 , 一个特殊的概念,None Null

Timestamp：时间戳

`Date`：存储当前日期或时间unix时间格式 (我们一般不用这个Date类型,时间戳可以秒杀一切时间类型)



### 增删改查相关

##### 新增：

	db.Logs.insert(
	    {
	        "name":"test4",	// 字符串
	        "age": NumberLong("123"), // 纯数字， 如果不用 NumberLong 包裹，会被shell判断为Double
	        "money": NumberDecimal("123.55"), // 一般用于货币
	        "isChinese": true,	// Boolean 
	        "price": 3.14,		// 双精度浮点数
	        "hobby":["book", "tea", "ball"],	// 列表或数组
	        "pet": {	// 子文档	
	            "name":"dog",
	            "age": 2
	        },
	        "createTime": new Date()	// 日期，实际上不常用，常用的应该是时间戳
	    }
	)


##### 更新部分字段：

```
db.Logs.update(
    {"name":"test"}, // 类似于SQL WHEHE查询条件
    {$set: {"age":14}},	// 类似于 SQL SET 更新部分值
    {multi: true}	// 是否更新所有的匹配项
)
```



##### 更新覆盖文档：

```
db.Logs.save(
    {
        "_id": new ObjectId("6075848a659da62f8061c964"),	// 根据主键进行更新
        "age": 16,
        "newFields": "新字段",
        "name": "新名字，旧名字会被直接覆盖掉"
    }
)

// 覆盖后，这条记录只会有这些值，更新数据时尽量使用 update，避免数据覆盖
```



##### 文档删除：

```
db.Logs.remove({"_id": new ObjectId("607582a7659da62f8061c961")})
```



##### 文档查询：

查询规则：

```text
db.collection.find(query, projection)
# query：查询条件，类似于SQL中的WHERE部分
# projection：可选，使用投影操作符指定返回的键
```



与 SQL 语法的对比

| 操作       | 格式                     | SQL中的类似语句                |
| ---------- | ------------------------ | ------------------------------ |
| 等于       | `{<key>:<value>}`        | `where title = 'MongoDB 教程'` |
| 小于       | `{<key>:{$lt:<value>}}`  | `where likes < 50`             |
| 小于或等于 | `{<key>:{$lte:<value>}}` | `where likes <= 50`            |
| 大于       | `{<key>:{$gt:<value>}}`  | `where likes > 50`             |
| 大于或等于 | `{<key>:{$gte:<value>}}` | `where likes >= 50`            |
| 不等于     | `{<key>:{$ne:<value>}}`  | `where likes != 50`            |

常用的查询语法

```json
db.Logs.find(
    {
        "name":"test",
        "age": {$gte: 14, $eq: 14, $lte: 14},
        // and 直接用 , 分割即可，不需要显示标志
        
        // or 和 and 一起使用的时候，使用这种方式进行分割
        $or: [{"_id": ObjectId("60758311659da62f8061c962")}, {"_id": ObjectId("60758392659da62f8061c963")}]
    }
)
// 使用limit来限制查询返回的数量
.limit(1)
// 使用 skip 来跳过指定数量，配置起来便是分页查询
.skip(1)
// 使用 sort 来进行排序，键名对应顺序，1为升序，-1为降序
.sort({"_id": 1})
```



索引

```json
// 查询索引
db.Logs.getIndexes(); 

// 创建索引
db.Logs.createIndex(
    // 创建了 name 和 age 的复合索引，1表示升序索引，-1表示降序索引
    {"name":1, "age": -1}, 
    {background: true, unique: false, name:"index_name"}
    // background：建索引过程会阻塞其它数据库操作，设置为true表示后台创建，默认为false
    // unique：设置为true表示创建唯一索引
    // name：指定索引名称，如果没有指定会自动生成
)
```



聚合

```json
db.Logs.aggregate([
    {$group : 
        // 使用 $group 字段进行分组
        {"_id": "$name", 
        // 这个_id ，表示使用哪个字段作为聚合键名
        total: {$sum: 1} 
        // total: {$max: "$price"} 
        // max 后面通过 $字段进行灵活操作
        // total 为自定义字段，$sum 表示累加，$avg 平均数，$min 计算最小值 $max 计算最大值
        }
    }
])

// 这条语句类似于 SELECT name, count(*) FROM Logs GROUP BY name;
```

