package concurrency.section2.创建有响应的用户界面;

import java.io.IOException;

/**
 * @ Author: liuqianshun
 * @ Description: 无法响应的用户界面
 *
 * 书671案例
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class UnresposiveUI {
    private volatile double d = 1;

    public UnresposiveUI() throws IOException {
        // 1. 专注于运算
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        // 2. 专注于读取控制台输入
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        new UnresposiveUI();
    }
}

