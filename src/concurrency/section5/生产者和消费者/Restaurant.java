package concurrency.section5.生产者和消费者;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书711案例
 *
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
