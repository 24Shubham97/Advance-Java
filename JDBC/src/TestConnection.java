import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		//testGet(14);
		testSelect();

	}

	public static void testAdd() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		Statement stmt = conn.createStatement();

		int id = 15;
		String fname = "Lali";
		String lname = "Sardar";
		int salary = 50040;
		int dept_id = 2;

		PreparedStatement ps = conn.prepareStatement("INSERT into employee values(?,?,?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, salary);
		ps.setInt(5, dept_id);

		int i = ps.executeUpdate();

		System.out.println(i);

		System.out.println("Inserted");
	}

	public static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		Statement stmt = conn.createStatement();

		String fname = "Neeraj";
		String lname = "Chopra";
		int salary = 55000;
		int dept_id = 5;
		int id = 5;

		PreparedStatement ps = conn.prepareStatement("update employee set fname=?,lname=?,salary=?,dept_id=? where id=?");

		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setInt(3, salary);
		ps.setInt(4, dept_id);
		ps.setInt(5, id);

		int i = ps.executeUpdate();

		System.out.println(i);

		System.out.println("updated");
	}

	public static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		Statement stmt = conn.createStatement();

		int id = 10;

		PreparedStatement ps = conn.prepareStatement("DELETE from employee where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println(i);

		System.out.println("Deleted");
	}

	public static void testGet(int i) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		
				
		PreparedStatement ps = conn.prepareStatement("select * from employee  where id = ?");
		
		ps.setInt(1,i);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
		}
		
		System.out.println("Fetch by Primary key");
	}



	public static void testSelect() throws Exception 
	{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
	
			
	PreparedStatement ps = conn.prepareStatement("select * from employee");
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
		System.out.print("\t"+rs.getString(1));
		System.out.print("\t"+rs.getString(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t"+rs.getString(4));
		System.out.println("\t"+rs.getString(5));
	}
	
	System.out.println("Selected Data");
}

}
