package www.newgen.com;

import java.sql.*;

public class connection {
	
	public Connection con;
	public Statement stmnt;
	
	public connection() {
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///emp_management","root","");
			stmnt = con.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
