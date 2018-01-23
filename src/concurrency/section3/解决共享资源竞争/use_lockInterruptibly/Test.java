package concurrency.section3.解决共享资源竞争.use_lockInterruptibly;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-18
 * @ Modified:
 **/
public class Test {
    private ReentrantLock lock = new ReentrantLock();


    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= 10000)
                    break;
                //插入数据
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}
