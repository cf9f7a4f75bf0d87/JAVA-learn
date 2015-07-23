## java lession note 05

* 01  File类的实例与硬盘有无对应文件无关
* 02  工程中文件路径尽量使用相对路径；使用绝对路径的话，移植性不好
* 03  Java 路径类型:
	* 	URI形式的绝对资源路径
      如：file:/D:/java/eclipse32/workspace/jbpmtest3/bin/aaa.b
	* 	本地系统的绝对路径
      D:/java/eclipse32/workspace/jbpmtest3/bin/aaa.b
	*		相对于classpath的相对路径
      如：相对于 file:/D:/java/eclipse32/workspace/jbpmtest3/bin/这个路径的相对路径。其中，bin是本项目的classpath。所有的Java源文件编译后的.class文件复制到这个目录中。
	*   相对于当前用户目录的相对路径
      就是相对于System.getProperty("user.dir")返回的路径。
>     对于一般项目，这是项目的根路径。对于JavaEE服务器，这可能是服务器的某个路径。这个并没有统一的规范！
      所以，绝对不要使用“相对于当前用户目录的相对路径”。然而：
      默认情况下，java.io 包中的类总是根据当前用户目录来分析相对路径名。此目录由系统属性 user.dir 指定，通常是 Java 虚拟机的调用目录。
      这就是说，在使用java.io包中的类时，最好不要使用相对路径。否则，虽然在J2SE应用程序中可能还算正常，但是到了J2EE程序中，一定会出问题！而且这个路径，在不同的服务器中都是不同的！

* 04	File中getCanonicalPath() 完成相对路径到绝对路径的转换
> 这个路径的文件可以是不存在的，这里只是完成一个转换

* 05 	File .length() 返回一个long型的数据 返回字节数
* 06	File 读取操作文件属性，但对其内容无能为力
* 07 	RandomAccessFile 用于对文件随机读写 .它是一个独立的类，直接继承了Object. 当然，灵活的代价是开销略大而且较慢.
> RandomAccessFile的绝大多数功能，但不是全部，已经被JDK 1.4的nio的"内存映射文件(memory-mapped files)"给取代了，你该考虑一下是不是用"内存映射文件"来代替RandomAccessFile了

* 08	流是一组有顺序的，有起点和终点的字节集合，是对数据传输的总称或抽象 .流的本质是数据传输. 一般是单向 不可逆的（除了 reset之类de方法 )
* 09  流分类： 
	*	方向： 输入流，输出流
	* 	内容： 字节流，字符流
	* 	功能： 节点流，处理流（过滤器）	
* 10	类名用大驼峰法，函数名和属性使用小驼峰法
* 11	继承结构 BufferedInputStream ----> FilterInputStream -----> InputStream
> BufferedInputStream 对FilterInputStream 使普通的文件输入流具有了内存缓存功能，通过内存缓存减少类磁盘I/O次数

	
