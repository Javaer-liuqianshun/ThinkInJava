package concurrency.section2.thread类;

/**
 * @ Author: liuqianshun
 * @ Description:  Thread类的使用
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/
public class BasicThread extends Thread {

    //重写run方法,调用start()方法会执行run()方法
    @Override
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

