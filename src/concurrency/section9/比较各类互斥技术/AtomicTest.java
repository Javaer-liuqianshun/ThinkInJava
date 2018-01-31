package concurrency.section9.比较各类互斥技术;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class AtomicTest extends Accumulator {

    {
        id = "Atomic";
    }

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        value.getAndAdd(preLoaded[i]);
        if (++i >= SIZE) index.set(0);
    }

    @Override
    public long read() {
        return value.get();
    }
}
