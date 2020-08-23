import java.sql.*;
import java.io.*;
import java.util.Scanner;

class Brainy
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anuj","root","123456");
		Statement stmt = con.createStatement();
		
		
		Scanner sc = new Scanner(System.in);
		String tabilName;
		
		System.out.println("enter tabil name");
		tabilName=sc.next();

		
		String sql= "SELECT * FROM "+ tabilName;
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int c = rsmd.getColumnCount();
		for(int i=1;i<=c;i++){
			System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
		}
		System.out.println("done");
	}
}