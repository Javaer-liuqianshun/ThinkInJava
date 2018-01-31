package collection.section9.散列与散列码;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书488案例
 *
 *  map = {Groundhog(土拨鼠) #8=这个冬天至少6周, Groundhog(土拨鼠) #4=这个冬天至少6周, Groundhog(土拨鼠) #0=这个冬天至少6周, Groundhog(土拨鼠) #7=早春, Groundhog(土拨鼠) #5=早春, Groundhog(土拨鼠) #9=这个冬天至少6周, Groundhog(土拨鼠) #1=这个冬天至少6周, Groundhog(土拨鼠) #3=早春, Groundhog(土拨鼠) #6=早春, Groundhog(土拨鼠) #2=早春}
 *  Looking up prediction for Groundhog(土拨鼠) #3
 *  Key not found: Groundhog(土拨鼠) #3
 *
 *  出现问题: 无法找到数字3这个键
 *      原因:Groundgoh自动地继承自基类Object,所以这里使用Object的hashCode()方法生成散列码,
 *          但是Object的hashCode()默认使用对象地址计算散列码.因此,由于Groundhog(3)生成的第一
 *          个实例的散列码与由Groundhog(3)生成的第二个实例的散列码是不同的.
 *
 *      解决办法: 重写hashCode(),但是仍无法正常工作,因为如果hashcode相同会使用equals()方法判断当前的键是否与表中存在的键相同,
 *                  所以还需要重写equals()方法.默认的Object中的equals()是比较对象的地址
 *
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class SpringDetecor {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> hog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(hog.newInstance(i),new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog gh = hog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh))
            System.out.println(map.get(gh));
        else
            System.out.println("Key not found: " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
