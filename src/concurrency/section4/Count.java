package concurrency.section4;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Count {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int value() {
        return count;
    }
}
