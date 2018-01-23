package concurrency.section5.生产者和消费者;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal == null){
                        // 没有已炒好的菜,服务员等待
                        wait();
                    }
                }
                System.out.println("服务员拿到已炒好的菜: " + restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson interrupted");
        }
    }
}
