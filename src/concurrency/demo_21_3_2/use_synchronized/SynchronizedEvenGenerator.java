package concurrency.demo_21_3_2.use_synchronized;

/**
 * @ Author: liuqianshun
 * @ Description:  使用synchronized关键字
 *
 * 书678案例
 *
 * 使用synchronized关键字,保证共享资源是同步的
 *
 * 共享资源被某个线程访问时,加锁,其他线程被阻塞,
 * 当该线程访问完共享资源后,解锁,其他线程可以访问,
 * 使用synchronized关键字是自动加锁和解锁
 * 并重复上述操作
 *
 *
 * 线程释放锁只会有两种情况:
 * (1)获取锁的线程执行完了该代码块,然后线程释放对锁的占有
 * (2)线程发生异常,此时JVM会让线程自动释放锁
 *
 *
 *
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
