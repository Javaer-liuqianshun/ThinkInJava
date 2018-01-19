package concurrency.demo2_thread;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/

/**
 * Thread类的使用
 */
public class BasicThread extends Thread {

    //重写run方法，run方法的方法体就是现场执行体
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  " + i);

        }
    }

    public static void main(String[] args) {
        new BasicThread().start();
        new BasicThread().start();
    }
}

