package concurrency.demo_21_3_3.volatile_explain;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/

/**
 * volatile关键字,保证了操作的可见性,被volatile关键字修饰的变量为共享变量
 * <p>
 * 并发编程的三概念: 原子性,可见性和时序性
 * <p>
 * 可见性原理: 当一个共享变量被修改,会立即更新到主内存中,其他线程的工作内存(及缓存)中缓存的共享变量的 缓存行 失效,
 * 这时又会在主内存中读取该共享变量的值,所以volatile保证了变量的可见性
 *
 * volatile能保证可见性和时序性,但是不能保证原子性 所有不能替代synchronized关键字,但是效率比synchronized高
 */
public class TestVolatile {
    public volatile int i = 0;

    public void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile t = new TestVolatile();
        for (int j = 0; j < 10; j++) {
            new Thread() {
                @Override
                public void run() {
                    for (int k = 0; k < 1000; k++) {
                        t.increase();
                    }
                }
            }.start();
        }


        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(t.i);
    }

}
