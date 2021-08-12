import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class InsertStoredProcedure 
{
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays","root","root");
		
		CallableStatement callStmt = conn.prepareCall("{CALL TestInsert(?,?,?,?,?)}");
		
		//callStmt.registerOutParameter(1, Types.INTEGER);
		callStmt.setInt(1,22);
		callStmt.setString(2,"Rahul");
		callStmt.setString(3,"Chouhan");
		callStmt.setInt(4,52000);
		callStmt.setInt(5,2);
		
		callStmt.execute();
		
		//int count =  callStmt.getInt(1);
		
		System.out.println("DONE");
	}
}
