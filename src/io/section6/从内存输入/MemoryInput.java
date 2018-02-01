package io.section6.从内存输入;

import java.io.IOException;
import java.io.StringReader;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 书541案例
 * <p>
 * 从内存输入
 * @ Date: Created in 2018-02-01
 * @ Modified:
 **/
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String str = "abcdefghijklmn...";
        // 此时str是存储在内存上的,所以new StringRead()是从内存输入
        StringReader in = new StringReader(str);
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }
        in.close();
    }
}
