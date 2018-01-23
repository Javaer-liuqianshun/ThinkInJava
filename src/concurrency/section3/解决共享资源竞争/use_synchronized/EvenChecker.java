package concurrency.section3.解决共享资源竞争.use_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:使用synchronized关键字
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
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int value = generator.next();
            if (value % 7 != 0) {
                System.out.println(value + " 不是7的倍数,关闭7的倍数产生!");
                generator.cancel();
            }
        }
    }

    /**
     * 测试各种类型的IntGenerator
     *
     * @param generator
     * @param ident
     */
    public static void test(IntGenerator generator, int ident) {
        ExecutorService exec = null;
        for (int i = 0; i < ident; i++) {
            exec = Executors.newCachedThreadPool();
            exec.execute(new EvenChecker(generator, i));
        }
        exec.shutdown();
    }

    /**
     * 指定ident
     *
     * @param generator
     */
    public static void test(IntGenerator generator) {
        test(generator, 100);
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
