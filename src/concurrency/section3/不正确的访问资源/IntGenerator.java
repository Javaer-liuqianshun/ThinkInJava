package concurrency.section3.不正确的访问资源;

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
