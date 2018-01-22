package concurrency.demo_21_5_4.blockingqueue_2;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Toast {
    public enum Status {
        DRY,/* 制作吐司 */
        BUTTERED,/* 给吐司摸黄油 */
        JAMMED,/* 摸过黄油后给吐司涂果酱 */
        ;
    }
    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        id = idn;
    }

    public void butter(){
        status = Status.BUTTERED;
    }

    public void jam(){
        status = Status.JAMMED;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " +status;
    }
}
