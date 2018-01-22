package concurrency.demo_21_2_1;

/**
 * @ Author: liuqianshun
 * @ Description:定义任务
 *
 * 书654案例
 *
 * 并发入门案列一: 实现Runnable接口,实现Runnable接口中run()方法
 *
 *
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/
public class LiftOff implements Runnable{
    private int countDown = 10;
    private static int taskCount = 0;
    /** targetInstance为final,对象一旦创建就无法修改,用来区分任务的多个实例 */
    private final int targetInstance = taskCount ++;

    public LiftOff(){

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+targetInstance +"("+ (countDown>0?countDown:"liftoff")+"),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            status();
            /** Thread静态方法yield(),声明现在可以切换线程了 */
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
