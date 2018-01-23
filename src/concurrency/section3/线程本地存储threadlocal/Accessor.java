package concurrency.section3.线程本地存储threadlocal;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        ThreadLocalVariableHolder.increment();
        System.out.println(this);
        Thread.yield();
    }

    @Override
    public String toString() {
        return "#" + id + ":" + ThreadLocalVariableHolder.get();
    }
}
