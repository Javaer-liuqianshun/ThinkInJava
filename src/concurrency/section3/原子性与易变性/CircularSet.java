package concurrency.section3.原子性与易变性;

/**
 * @ Author: liuqianshun
 * @ Description: 存储序列数
 * @ Date: Created in 2018-01-19
 * @ Modified:
 **/
public class CircularSet {
    // 数组
    private int[] arr;
    // 数组长度
    private int len;
    // 数组索引
    private int index = 0;

    public CircularSet(int size) {
        arr = new int[size];
        len = size;
        // 初始化数组的值
        for(int i = 0;i<size;i++){
            arr[i] = -1;
        }
    }

    /**
     * 向数组中添加元素
     */
    public synchronized void add(int i){
        arr[index] = i;
        // 获取下一个索引值
        index = (++index) % len;
    }

    /**
     * 判断数组中是否包含某个元素
     */
    public synchronized boolean contains(int val){
        for(int i=0;i<len;i++){
            if(arr[i] == val){
                return true;
            }
        }
        return false;
    }
}
