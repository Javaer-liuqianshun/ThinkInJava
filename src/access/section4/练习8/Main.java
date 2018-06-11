package access.section4.练习8;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-05-31
 * @ Modified:
 **/
public class Main {
	public static void main(String[] args) {
		Connection connection = ConnectionManager.getConnection();
		while (connection != null) {
			System.out.println(connection);
			connection.doSomething();
			connection = ConnectionManager.getConnection();
		}
	}
}
