package generics.section3.斐波拉契数;

import generics.section3.Generator;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 斐波拉契数:  第一位和第二位数为1,后面的数为前两位数的和
 *
 *
 * @ Date: Created in 2018-06-11
 * @ Modified:
 **/
public class Fibonacci implements Generator<Integer> {

	private int count = 0;

	@Override
	public Integer next() {
		return fib(count++);
	}


	private int fib(int n) {
		if (n < 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(fib.next() + " ");
		}
	}
}
