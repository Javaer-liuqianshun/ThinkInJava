package concurrency.section2.后台线程;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 *
 *
 * 后台线程(daemon简单使用):
 *      后台线程是指程序运行的时候在后台提供一种通用服务的线程,
 *      当所有的非后台线程结束时,程序也终止,同时会杀死进程中所有后台线程
 *      main()就是一个非后台线程
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/

/**
 * 后台线程(daemon简单使用)
 * <p>
 * 后台线程是指程序运行的时候在后台提供一种通用服务的线程,
 * 当所有的非后台线程结束时,程序也终止,同时会杀死进程中所有后台线程
 * main()就是一个非后台线程
 */
public class SimpleDaemonUse implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<5;i++){
            Thread t = new Thread(new SimpleDaemonUse());
            // 设置该线程为后台线程,必须在线程启动之前设置
            t.setDaemon(true);
            // 启动线程
            t.start();
        }
        Thread.sleep(250);
        /**
         *  非后台线程(这里main()是非后台线程)结束,所有后台线程也结束
         */
        System.out.println("所有后台线程结束");

    }
}
