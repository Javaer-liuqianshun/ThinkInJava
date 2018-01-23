package concurrency.section3.两个任务同时访问同一个对象;

/**
 * @ Author: liuqianshun
 * @ Description: 两个任务进入同一对象
 *
 *  DualSynch.f()在this上同步,而g()在syncObject上同步.
 *  因此两个同步是相互独立的,任何一个线程都没有因为另一个线程而被阻塞
 *
 *
 *
 *
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/
public class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        // 开启一个线程执行f()方法;
        new Thread(){
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();
        // main()线程执行g()方法;
        dualSynch.g();
    }
}
