package concurrency.section3.解决共享资源竞争.user_lock;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
