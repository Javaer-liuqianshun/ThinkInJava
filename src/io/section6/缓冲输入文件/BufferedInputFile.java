package io.section6.缓冲输入文件;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书540案例
 *
 * 缓冲输出文件
 *
 * @ Date: Created in 2018-02-01
 * @ Modified:
 **/
public class BufferedInputFile {
    public static String read(String filename) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=in.readLine())!=null){
            // 必须添加换行符,因为readLine()已经将它们删除
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(read("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section6\\缓冲输入文件\\BufferedInputFile.java"));
    }
}
