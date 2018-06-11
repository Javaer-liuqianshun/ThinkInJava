package polymorphism.section3.引用计数跟踪共享对象数量;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-06-01
 * @ Modified:
 **/
public class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;

	public Composing(Shared shared) {
		System.out.println("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}

	protected void dispose() {
		System.out.println("disposing " + this);
		shared.dispose();
	}

	@Override
	public String toString() {
		return "Composing " + id;
	}
}
