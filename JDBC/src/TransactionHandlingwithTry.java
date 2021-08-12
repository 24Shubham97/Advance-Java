import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHandlingwithTry {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		
		conn.setAutoCommit(false);
		
		Statement stmt = conn.createStatement();

		try {
		
		stmt.executeUpdate("Insert into employee values(18,'Ravi','Rathore',15000,4)");
		stmt.executeUpdate("Insert into employee values(19,'Ravi','Rathore',15000,4)");
		stmt.executeUpdate("Insert into employee values(14,'Ravi','Rathore',15000,4)");
		stmt.executeUpdate("Insert into employee values(14,'Ravi','Rathore',15000,4)");

		conn.commit();
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			conn.rollback();
		}
		
		

		stmt.close();
		conn.close();
	}
}
