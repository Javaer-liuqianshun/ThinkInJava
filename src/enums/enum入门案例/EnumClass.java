package enums.enum入门案例;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书590案例
 *
 * enum常用方法:
 *  ordinal():返回一个int值,是每个enum实例在声明时的次序,从0开始
 *  getDeclaringClass():返回所属enum类
 *  name():返回enum实例声明是的名字
 *  values():返回enum实例的数组
 *  valueOf():根据给定的名字返回响应的enum实例
 *
 * @ Date: Created in 2018-02-05
 * @ Modified:
 **/
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWING) + "");
            System.out.println(s.equals(Shrubbery.CRAWING) + "");
            System.out.println(s == Shrubbery.CRAWING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("--------------------------------------");
        }

        for (String s:"HANGING CRAWING GROUND".split(" ")){
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
