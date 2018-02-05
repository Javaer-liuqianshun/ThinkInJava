package io.section12.序列化的控制;

import java.io.*;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书575案例
 *
 * 继承Externalizable,代替Serializable接口,来对序列化过程进行控制
 * 把所需要的序列化的部分在writeExternal()中写入序列化文件
 *
 *
 *  Exception in thread "main" java.io.InvalidClassException: io.section12.序列化的控制.Blip2; no valid constructor
 *      at java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:157)
 *      at java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:862)
 *      at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2038)
 *      at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1568)
 *      at java.io.ObjectInputStream.readObject(ObjectInputStream.java:428)
 *      at io.section12.序列化的控制.Blips.main(Blips.java:33)
 *
 *  报找不到Blip2的构造器,
 *  Blip2中的构造器没有权限修饰符,默认default,而Blip1中的构造器的权限修饰符是public
 *
 *  说明使用Externalizable接口,反序列化必须要要有public的无参构造器
 *  而Serializable反序列化不需要构造器,因为Serializable对象完全以二进制存储
 *
 * @ Date: Created in 2018-02-04
 * @ Modified:
 **/
public class Blips{
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\序列化的控制\\blips.txt"));
        System.out.println("Saving objects");
        o.writeObject(blip1);
        o.writeObject(blip2);
        o.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\序列化的控制\\blips.txt"));
        System.out.println("恢复blip1:");
        blip1 = (Blip1) in.readObject();
        System.out.println("恢复blip2:");
        Thread.sleep(2);
        blip2 = (Blip2) in.readObject();

    }
}
