package concurrency.section3.解决共享资源竞争.user_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    // 创建锁对象
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public int next() {
        // 获取锁
        lock.lock();
        try {
            ++currentEvenValue;
            ++currentEvenValue;
            ++currentEvenValue;
            ++currentEvenValue;
            ++currentEvenValue;
            ++currentEvenValue;
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            // 释放锁
            lock.unlock();
        }

    }
}
