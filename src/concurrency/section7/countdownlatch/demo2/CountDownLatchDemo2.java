package concurrency.section7.countdownlatch.demo2;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 结果:
 *      子线程Thread-0正在执行
 *      等待两个子线程执行完毕...
 *      子线程Thread-1正在执行
 *      子线程Thread-1执行完毕
 *      子线程Thread-0执行完毕
 *      两个子线程已经执行完毕
 *      继续执行主线程
 *
 * 说明: 主线程使用latch.await()后被挂机,
 *      new CountDownLatch(2)参数为2指要等待两个子线程执行完并调用latch.countDown()后,
 *      主线程才被唤醒
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {

                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {

                }

            }
        }.start();

        try {
            System.out.println("等待两个子线程执行完毕...");
            latch.await();
            System.out.println("两个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {

        }


    }

}
