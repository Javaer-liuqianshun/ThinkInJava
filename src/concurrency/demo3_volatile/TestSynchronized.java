package concurrency.demo3_volatile;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/
public class TestSynchronized {
    public int i = 0;

    public synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSynchronized t = new TestSynchronized();
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
