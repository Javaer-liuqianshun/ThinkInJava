package polymorphism.section3.引用计数跟踪共享对象数量;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-06-01
 * @ Modified:
 **/
public class ReferenceCounting {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composings = {new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared)};
		for (Composing item : composings) {
			item.dispose();
		}
	}
}
