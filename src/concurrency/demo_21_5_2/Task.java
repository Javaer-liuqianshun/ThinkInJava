package concurrency.demo_21_5_2;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Task implements Runnable {
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        /* 在Blocker类中锁synchionized(this)其中this这里是Task */
        blocker.waitingCall();
    }
}
