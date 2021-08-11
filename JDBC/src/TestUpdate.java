import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate 
{
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays","root","root");
		
		Statement stmt = conn.createStatement();
		
	//int i = stmt.executeUpdate("Insert into employee values(14,'Ravi','Rathore',15000,4)");
		//int i = stmt.executeUpdate("update employee set fname='Anurag',lname = 'Solanki',salary=43000 where id=14");
		int i = stmt.executeUpdate("delete from employee where id =9");
		
		System.out.println(i);
		System.out.println("delete");
	
	stmt.close();
	conn.close();
	}
}
