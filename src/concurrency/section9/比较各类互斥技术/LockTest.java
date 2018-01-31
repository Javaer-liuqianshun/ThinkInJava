package concurrency.section9.比较各类互斥技术;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class LockTest extends Accumulator {

    {
        id = "Lock";
    }

    Lock lock = new ReentrantLock();

    @Override
    public void accumulate() {
        lock.lock();
        try {
            value += preLoaded[index++];
            if (index >= SIZE) index = 0;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public long read() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }

    }
}
