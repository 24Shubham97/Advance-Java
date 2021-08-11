import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectivitySQL{

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs= stmt.executeQuery("select * from Employee");
		
		while(rs.next())
		{
			System.out.print("\t"+rs.getString(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.println("\t"+rs.getString(5));
			
			
			
		}
		stmt.close();
		conn.close();
	}
	

}
