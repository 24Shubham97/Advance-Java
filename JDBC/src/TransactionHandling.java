import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionHandling 
{
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays","root","root");
		
		Statement stmt = conn.createStatement();
	
	conn.setAutoCommit(false);	
		
	stmt.executeUpdate("Insert into employee values(18,'Ravi','Rathore',15000,4)");
	stmt.executeUpdate("Insert into employee values(19,'Ravi','Rathore',15000,4)");
	stmt.executeUpdate("Insert into employee values(20,'Ravi','Rathore',15000,4)");
	stmt.executeUpdate("Insert into employee values(21,'Ravi','Rathore',15000,4)");
	
	conn.commit();
	
	
	//int i = stmt.executeUpdate("update employee set fname='Anurag',lname = 'Solanki',salary=43000 where id=14");
		//int i = stmt.executeUpdate("delete from employee where id =9");
		
		//System.out.println(i);
		System.out.println("inserted");
	
	stmt.close();
	conn.close();
	}
}
