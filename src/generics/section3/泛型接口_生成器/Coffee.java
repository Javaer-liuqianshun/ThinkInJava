package generics.section3.泛型接口_生成器;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-06-08
 * @ Modified:
 **/
public class Coffee {
	private static long counter = 0;
	private final long id = counter++;
	public String toString (){
		return getClass().getSimpleName() + " " + id;
	}
}
