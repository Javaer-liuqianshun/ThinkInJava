package concurrency.demo5_callable;

import java.util.concurrent.Callable;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class MyCallable implements Callable<String> {
    private static int i;
    private final int id = i ++;
    @Override
    public String call() throws Exception {
        return "id = "+id;
    }
}
