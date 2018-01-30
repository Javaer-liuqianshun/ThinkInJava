package collection.section9.重写equlas和hashcode;

import java.util.Random;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow)
            return "这个冬天至少6周";
        else
            return "早春";

    }
}
