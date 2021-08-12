import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStmt1 
{
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays","root","root");
		
		CallableStatement callStmt = conn.prepareCall("{?=CALL empCount()}");
		
		callStmt.registerOutParameter(1, Types.INTEGER);
		
		//callStmt.setString(2, "Vijay");
		//callStmt.setString(3, "100");
		
		callStmt.execute();
		
		System.out.println("count : "+callStmt.getInt(1));
	}
}
