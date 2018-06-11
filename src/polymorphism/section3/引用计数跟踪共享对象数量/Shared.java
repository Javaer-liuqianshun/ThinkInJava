package polymorphism.section3.引用计数跟踪共享对象数量;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * Shared是共享对象，当没有对象引用她时，才能被清理(即refcount为0时)
 *
 *
 *
 * @ Date: Created in 2018-06-01
 * @ Modified:
 **/
public class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;

	public Shared() {
		System.out.println("Creating " + this);
	}

	public void addRef() {
		refcount++;
	}

	protected void dispose() {
		if (--refcount == 0) {
			System.out.println("Disposing  " + this);
		}
	}

	@Override
	public String toString() {
		return "Shared " + id;
	}
}
