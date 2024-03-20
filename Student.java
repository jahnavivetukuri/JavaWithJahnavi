import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	
	private static final String url = "jdbc:mysql://localhost:3306/student_database";
	private static final String username = "username";
	private static final String password = "password";
	
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(url,  username, password);
			
			Statement statement = connection.createStatement();
			
			//PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS //student ("
			//		+ "id INT AUTO_INCREMENT PRIMARY KEY,"
			//		+ "name VARCHAR(100),"
			//		+ "age INT)");
			String createTable = "CREATE TABLE IF NOT EXISTS student ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "name VARCHAR(100),"
					+ "age INT)";
			statement.executeUpdate(createTable);
			System.out.println("table created");
			
			String insert = "INSERT INTO student (name, age) VALUES ('Katie', 30)";
			statement.executeUpdate(insert);
			System.out.println("Data inserted");
			
			
			String update = "UPDATE student SET age = 28 WHERE name = 'Jahnavi'";
			statement.executeUpdate(update);
			

			String select = "SELECT * FROM student";
			ResultSet result = statement.executeQuery(select);
			
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				System.out.println("ID: "+id+" Name: "+name +" Age: "+age);
			}
			
			String delete= "DELETE FROM student WHERE age=30";
			statement.executeUpdate(delete);
			
			System.out.println("After deleting");
			//String select2 = "SELECT * FROM student";
			ResultSet result2 = statement.executeQuery(select);
			
			while(result2.next()) {
				int id = result2.getInt("id");
				String name = result2.getString("name");
				int age = result2.getInt("age");
				System.out.println("ID: "+id+" Name: "+name +" Age: "+age);
			}
			
			result.close();
			result2.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
