package nio.交换相邻字符;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书561案例
 *
 * @ Date: Created in 2018-02-03
 * @ Modified:
 **/
public class UsingBuffers {
    private static void changeChar(CharBuffer buffer){
        while (buffer.hasRemaining()){
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = buffer.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        changeChar(cb);
        System.out.println(cb.rewind());
        changeChar(cb);
        System.out.println(cb.rewind());
    }
}
