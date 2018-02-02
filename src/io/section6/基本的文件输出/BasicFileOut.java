package io.section6.基本的文件输出;

import java.io.*;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书542案例
 *
 * BufferedReader用来读取文件  readLine()读取一行
 * BufferedWriter用来写入文件
 *
 * @ Date: Created in 2018-02-02
 * @ Modified:
 **/
public class BasicFileOut {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section6\\基本的文件输出\\BasicFileOut.java");
        BufferedReader in = new BufferedReader(reader);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section6\\基本的文件输出\\out.txt"));
        int line = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.write(line++ + ": " + s + "\n");
        }
        out.close();
        in.close();
    }
}
