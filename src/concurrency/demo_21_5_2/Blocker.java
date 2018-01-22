package concurrency.demo_21_5_2;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Blocker {
    synchronized void waitingCall(){
        try {
            while (!Thread.interrupted()){
                wait();
                System.out.print(Thread.currentThread()+ " ");
            }
        }catch (InterruptedException e){

        }
    }

    synchronized void prod(){notify();}
    synchronized void prodAll(){notifyAll();}
}
