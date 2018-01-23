package concurrency.section2.定义任务;

/**
 * @ Author: liuqianshun
 * @ Description: 创建线程
 *
 * 书656案例
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class CreateThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
