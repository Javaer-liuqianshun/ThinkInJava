package access.section4.练习8;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-05-31
 * @ Modified:
 **/
public class Connection {

	private static int counter = 0;
	private int id = counter++;

	public Connection() {

	}

	@Override
	public String toString() {
		return "Connection " + id;
	}

	public void doSomething(){

	}
}
