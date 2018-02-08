package nio.bytebuffer的基本使用;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书553案例
 *
 * FileInputStream、FileOutputStream和RandomAccessFile中getChannel()来产生FileChannel对象.
 *
 * ByteBuffer类方法说明:
 *  put():填入一个或多个字节,或基本数据类型值
 *  wrap():将已存在的字节数组"包装"到ByteBuffer中
 *  allocate():用来创建(分配)ByteBuffer
 *  allocateDirect():产生一个与操作系统更高耦合性的"直接"缓冲器.但是,这种分配的开支会很大,
 *                  并且具体实现也随操作系统的不同而不同.
 *  read():读取FileChannel向ByteBuffer存储字节
 *  flip():在调用write()方法之前使用该方法,会获取最大的I/O速度
 *  write():向FileChannel写入数据
 *  clear():重新调用read()方法之前使用该方法,让每个read()做好准备
 *
 *  rewind():返回到数据开始部分
 *  reset():将此缓冲区的位置重置到之前mark的位置.
 *  remaining():返回(limit - position)
 *  hasRemaining():若有介于position和limit之间的元素,则返回true
 *  mark():将mark设置为position
 *
 * @ Date: Created in 2018-02-03
 * @ Modified:
 **/
public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String str1 = "C:\\idea Projects\\04\\thinkinjava_practice\\src\\nio\\bytebuffer的基本使用\\in.txt";
        String str2 = "C:\\idea Projects\\04\\thinkinjava_practice\\src\\nio\\bytebuffer的基本使用\\out.txt";
        FileChannel in = new FileInputStream(str1).getChannel();
        FileChannel out = new FileOutputStream(str2).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
