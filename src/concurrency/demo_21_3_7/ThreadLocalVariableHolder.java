package concurrency.demo_21_3_7;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value =  new ThreadLocal(){
        private Random random = new Random(47);

        @Override
        protected Integer initialValue() {
            synchronized (this){
                return random.nextInt(10000);
            }
        }
    };

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){
        return  value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            exec.execute(new Accessor(i));
        }
        Thread.sleep(3);
        exec.shutdownNow();
    }
}
