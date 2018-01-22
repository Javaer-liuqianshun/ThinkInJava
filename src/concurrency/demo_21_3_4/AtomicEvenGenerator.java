package concurrency.demo_21_3_4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/
public class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(7);
    }
}
