package collection.section9.重写equlas和hashcode;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class Groundhog2 {
    protected int number;
    public Groundhog2(int n ){
        number = n;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog2 && (number == ((Groundhog2) obj).number);
    }

    @Override
    public String toString() {
        return "Groundhog(土拨鼠) #" + number;
    }
}
