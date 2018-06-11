package generics.section3.泛型接口_生成器;

import generics.section3.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-06-08
 * @ Modified:
 **/
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

	private static Random rand = new Random(47);

	/* 数组: 保存字面量类 */
	private Class[] types = {Latte.class, Mocha.class, Cappuccino.class,
			Americano.class, Breve.class};

	public CoffeeGenerator() {
	}

	/* size用于 Iterable接口遍历计数 */
	private int size = 0;

	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {

		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}

		for (Coffee c : new CoffeeGenerator(5)){
			System.out.println(c);
		}
	}
}
