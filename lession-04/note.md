## java lession note 04

* 01  抽象函数 仅有声明 不实现 使用abstract 标识
> 抽象类中可以没有抽象函数；但是有抽象函数的类一定是抽象类

* 02  抽象类禁止实例化；但可以声明抽象类的引用变量，只能指向其派生的非抽象类的实例
* 03  多态的形式： 覆盖， 重载
* 04  接口是实体之间通信的标准，描述相互通信时交换数据的格式 .类似一种协议 .
* 05  接口内不能定义变量，只能含有常量（public final static )，和抽象函数定义
* 06  [师]开发中尽量不要修改原有接口，而是增加新的接口来实现升级或其他目的
> 如果你向一个接口中添加一个方法，你必须修改所有实现了这个接口的类

* 07  区别 接口没有构造函数，没有main，没有变量 ,支持多继承
* 08  接口引用变量指向一个实现了这个接口的对象 
* 09  接口可以强制转换成对应的对象 ，强转换之前用instanceof 测试是否可行
* 10  继承接口但是不完全实现的类为抽象类
* 11  继承的多个接口中如果含有同参同名同返回值函数，不会报错；如果含有同参同名不同返回值函数，报错
* 12  a instanceof B 如果对象a 的类类型 A与类类型B没有继承关系，则报错
* 13  克隆函数用于复制对象，按位复制，浅复制
* 14  默认 equals 即 == ; 对于具体业务需要覆盖equals函数
* 15  String 用== 比较，true意味着二者不仅值相同，而且二者是同一对象的引用
* 16  集合： Collection 无序； List 有序； Set 去重；
* 17  集合中只能放入Object(不能放入基本类型), 取出的仍是Object，需要强制转换
> java 5开始引入了autoboxing 和auto-unboxing机制，方便了基本类型和其对应的wrapper类型的转换。比如我们可以直接把一个基本类型的值赋给其wrapper类型，反之亦然；可以把一个基本类型直接放入容器里，封装的过程由编译器来完成；调用方法的时候可以直接匹配参数autoboxing和auto-unboxing之后的版本。

* 18 java 的8个基本类型对应了8个包装类    
