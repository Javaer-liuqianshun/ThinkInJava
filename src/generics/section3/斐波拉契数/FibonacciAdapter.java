package generics.section3.斐波拉契数;

import java.util.Iterator;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 在不改变Fibonacci类的源码下,实现Iterable接口
 * <p>
 * 采用适配器模式
 * @ Date: Created in 2018-06-11
 * @ Modified:
 **/
public class FibonacciAdapter extends Fibonacci implements Iterable<Integer> {

	private int n;

	public FibonacciAdapter(int count) {
		n = count;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return FibonacciAdapter.this.next();
			}
		};
	}

	public static void main(String[] args) {
		for (int i : new FibonacciAdapter(18)) {
			System.out.print(i + " ");
		}
	}
}
