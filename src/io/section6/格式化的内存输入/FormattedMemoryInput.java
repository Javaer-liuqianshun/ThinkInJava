package io.section6.格式化的内存输入;

import io.section6.缓冲输入文件.BufferedInputFile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 书541案例
 * <p>
 * 要读取格式化数据,必须使用DataInputStream
 * <p>
 * avaliable()方法检查能读取字节数
 * @ Date: Created in 2018-02-02
 * @ Modified:
 **/
public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section6\\格式化的内存输入\\FormattedMemoryInput.java")
                                .getBytes()));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
