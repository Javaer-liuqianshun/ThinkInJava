package concurrency.section3.解决共享资源竞争.use_synchronized;

/**
 * @ Author: liuqianshun
 * @ Description:
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


}
