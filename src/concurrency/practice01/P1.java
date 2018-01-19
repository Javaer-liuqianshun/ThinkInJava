package concurrency.practice01;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-15
 * @ Modified:
 **/
public class P1 implements Runnable {

    private static int taskCount;
    private final int id = taskCount ++;

    public P1() {
        System.out.println(id + ": 启动消息");
    }

    @Override
    public void run() {
        System.out.println(id + ": 1");
        Thread.yield();
        System.out.println(id + ": 2");
        Thread.yield();
        System.out.println(id + ": 3");
        Thread.yield();
        System.out.println(id + ": 关闭");
    }

    public static void main(String[] args) {
        for(int i = 0; i< 5;i++){
            new Thread(new P1()).start();
        }
    }
}
