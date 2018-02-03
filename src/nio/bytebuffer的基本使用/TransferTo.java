package nio.bytebuffer的基本使用;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书554案例
 *
 * 使用FileChannel类的transferTo()和transferFrom(),允许我们将一个通道和另一个通道直接连接
 * @ Date: Created in 2018-02-03
 * @ Modified:
 **/
public class TransferTo {
    public static void main(String[] args) throws IOException {
        String str1 = "C:\\idea Projects\\04\\thinkinjava_practice\\src\\nio\\bytebuffer的基本使用\\in.txt";
        String str2 = "C:\\idea Projects\\04\\thinkinjava_practice\\src\\nio\\bytebuffer的基本使用\\out.txt";
        FileChannel in = new FileInputStream(str1).getChannel();
        FileChannel out = new FileOutputStream(str2).getChannel();
        in.transferTo(0,in.size(),out);

        /**
         * or
         * out.transferFrom(in,0,in.size());
         */
    }
}
