package concurrency.section3.解决共享资源竞争.user_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:使用显示的Lock对象 对共享资源加锁
 *
 * 书678案例
 *
 * 使用lock对象的原因:
 * (1)synchronized关键字的缺陷--->当多个线程访问共享资源时,只有一个线程能够访问,其他线程就只有等待锁的释放,
 *                              这样就造成阻塞,效率低下
 * (2)lock对象不会主动释放锁,并且在发生异常,也不会释放锁.因此,使用lock必须在try_catch块中进行,并且释放锁的
 *      操作放到finally块中进行,防止发生出现异常造成死锁的情况
 *      模板:   Lock lock = ......;
 *              lock.lock();
 *              try{
 *                  // 处理任务
 *              }catch(){
 *                  // 捕获异常
 *              }finally{
 *                  // 释放锁
 *                  lock.unlock();
 *              }
 *
 * (3)lock对象获取锁的方式繁多--->lock():用来获取锁,如果锁已经被其他线程获取,则进行等待
 *                              tryLock():具有返回值,用来尝试获取锁,如果获取成功,返回true,反之返回false.即无论如何
 *                                     这个方法都会立即返回,在拿不到锁时不会一直等待
 *                              tryLock(Long time,TimeUnit unit):和tryLock()类似,只是这个方法在拿不到锁会等待一段
 *                                     时间,在此时间限期内还拿不到锁,就返回false
 *                              lockInterruptibly():可以中断等待的线程,假若线程A获取到了锁,而线程B只有在等待，
 *                                     那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程
 *
 *
 *
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
        EvenChecker.test(new MutexEvenGenerator());
    }
}
