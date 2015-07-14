## java learn note 11

*	01	Properties -> Hashtable -> Dictionary -> Object; 主要用来读取Java 配置文件；内容为名值对，只能放文本
* 02	GetProperty(String key) 用指定的键在此属性列表中搜索属性
* 03	GetProperty(String key,String value) 同上,但查不到时返回默认值(value)
*	03	load(InputStream inStream) 从输入流中读取属性列表
* 04	SetProperty(String key,String value) 设置键值对
* 05	store(OutputStream, String comments) 将键值对写到指定的文件
* 06	clear() 清空所有键值对
* 07	获得系统属性 使用System.getProperty(..);
* 08	java 命令行运行添加 classpath
> java -classpath C:\abc;D:\java;. HelloWorld
> 对于需要加载的类,从classpath 中查找,从前到后扫描,需要添加当前目录

* 09	Beans.instantiate(ClassLoader cls,String beanName);用来创建javabean,功能跟new 差不多,性能上要差一些
> 这种方法在文件系统搜索那个对象的一个序列化版本,如果找到序列化对象,则装入它,如果找不到它,则创建它

*	10	设计模式: 简单工厂模式
	*		解决的问题主要是如何去实例化一个合适的对象
	*		分离产品的创建者和消费者,有利于软件系统的结构化
	*		违背"开放封闭原则" : (新增产品必须修改工厂类)
	*		简单工厂模式的方法一般都是静态的,所以无法让子类继承,简单工厂模式无法形成基于基类的继承树结构
*	11	JDBC 流程: 注册并加载数据库驱动,一般使用Class.forName()；创建与数据库的链接Connection对象(这里就是工厂产生的)；创建SQL语句对象preparedStatement(sql);提交SQL语句,根据实际情况使用executeQuery()或者executeUpdate()；处理或者显示相应的结果；关闭数据库
