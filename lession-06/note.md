## java lession note 06

* 01  FileReader 用来读取文本文件，是面向字符流的
> 继承关系： FileReader -> InputStreamReader -> Reader -> Object

* 02  FileReader 最好使用BufferedReader 包装一下， 一提供效率，二提供方便（readLine等函数）
* 03  InputStream 直接继承Object ，其read 函数有三种形式
   *  `read()` Reads the next byte of data from the input stream 
   *  `read(byte[] b)` Read some number of bytes from the input stream and stores them into the buffer array b
   *  `read(byte[] b ,int off ,int len)` Reads up to len bytes of data from the input stream into an array of bytes
* 04  InputStreamReader 是字节流通向字符流的桥梁：它使用指定的charset 读取字节并将其解码为字符。这是一个处理流。
> 同样，为了效率，这个也用BufferedReader 包装一下比较好

* 05  FileInputStream 继承自InputStream ，是数据流 ，将文件变成字节流 ；经由InputStreamReader 包装则成为字符流
* 06  Throwable 类是java 语言中所有错误或异常的超类 ，有两个子类： Error 和Exception。 Error 一般是严重到无法处理 ，就不管了 。Exception 分为两类： RuntimeException（运行异常） ，CheckedException (检查异常）
* 07  运行异常，编译器不负责，不监督；这类异常通过合理编码，可以避免
* 08  检查异常，编译器监督，不解决的话不让通过；这类问题一般来说无法通过编码解决
* 09  try -- catch -- finally 异常处理完整语法
> finally 中如果有 return 的话，就会改写 返回值
```java
try{
  return 1;
}catch(Exception e){
//...
}finally{
  return 0; //返回值一直是零
}
```
 
* 10  unreachable  statement 是指那些一次也不可能执行的语句 ，比如放在return语句后的语句，某些break之后的语句等
* 11  throws 用于声明异常的抛出； throw 是功能语句，类似break（函数内部捕获） ,也像return（函数不捕获，抛出） ;
* 12  声明抛出的运行异常，编译器是不会监督的，爱捕获就捕获；声明抛出的检查异常，则必须捕获
* 13  发生异常后，后面的代码不能执行 (同一try块内的)
* 14  Iterator 迭代器，用来遍历集合之类的
```java
HashMap ma = new HashMap<String,String>;
//...
Set se = ma.keySet();
Iterator<String> it = se.iterator();
String s = null;
while(it.hasNext()){
   s = it.next();
}
```

* 15  Map 相当于字典，根据key,找到值；它是一种特殊的数组，它的索引可以不是数字。
* 16  泛型 ： 泛型类和泛型函数 ；定义类或者接口的时候，使用类型参数，直到使用时用具体的类型来替换
> 通配符 ： ？ ； List<?>声明了List中包含的元素类型是未知的；
> 试图对一个带通配符的泛型类进行操作的时候，总是会出现编译错误，就是因为通配符所表示的类型是未知的
> List<?> 中的元素只能通过Object 来引用；不方便，所以使用上下界来限制未知类型的范围. 
> List<? extends Number>说明List中包含的可能是Number及其子类，所以可以使用Number 的intValue等方法
> List<? super Number> 说明List中包含的是Number及其父类
> 可以把 extends 当成小于号；把 super 当作大于号

* 17  多看 API 文档...........................
