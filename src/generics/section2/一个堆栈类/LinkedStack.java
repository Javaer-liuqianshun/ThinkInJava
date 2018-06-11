package generics.section2.一个堆栈类;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 实现自己内部的链式存储机制
 * @ Date: Created in 2018-06-08
 * @ Modified:
 **/
public class LinkedStack<T> {

	/**
	 * 内部类,用于保存链式中每个节点
	 */
	private class Node<U> {
		U item;
		Node<U> next;

		Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			/* 如果节点内容(item)和下一指点节点(next)为空,则表示该系节点为链式最后一个节点 */
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<>();

	/**
	 *
	 * push操作
	 * 每调用push操作就会创建一个Node<T>对象
	 * 新添加的节点在最前面
	 * 新节点的next就指向老节点
	 *
	 *
	 *
	 * 最后一个节点 item 和 next 为 null
	 *
	 * @param item
	 */
	public void push(T item) {
		top = new Node<>(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<>();
		for (String s : "Phasers or stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
}
