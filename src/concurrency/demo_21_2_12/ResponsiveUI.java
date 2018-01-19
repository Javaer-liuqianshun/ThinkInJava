package concurrency.demo_21_2_12;

import java.io.IOException;

/**
 * @ Author: liuqianshun
 * @ Description: 响应用户界面
 *
 * 书671案例
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while(true){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        // System.in.read()控制台等待用户登录
        System.in.read();
        System.out.println(d);
    }
}
