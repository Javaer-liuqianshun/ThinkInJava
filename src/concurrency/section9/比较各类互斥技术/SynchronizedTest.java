package concurrency.section9.比较各类互斥技术;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class SynchronizedTest  extends Accumulator{

    {
        id = "synchroined";
    }
    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) index =0;
    }

    @Override
    public long read() {
        return value;
    }
}
