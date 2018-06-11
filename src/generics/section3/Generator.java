package generics.section3;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 泛型接口-生成器 ---------> 负责创建对象
 * <p>
 * 一般而言生产器只定义一个方法,该方法用以产生新的对象
 *
 * @ Date: Created in 2018-06-08
 * @ Modified:
 **/
public interface Generator<T> {
	T next();
}
