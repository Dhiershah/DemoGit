import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class Jdbc_Demo
{
	public static void main(String args[])
	{
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver"); //registering the driver
				//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","password");
				
				String url = "jdbc:mysql://localhost:3306/Demo";
				String username = "root";
				String password = "Venom.69";

				Connection con = DriverManager.getConnection(url, username, password);
				if (con != null) {
					System.out.println("Database Connected successfully");
				} else {
					System.out.println("Database Connection failed");
				}
			
				//here Demo is database name, root is username and password
				Statement stmt=con.createStatement();
				stmt.executeUpdate("Update EMPLOYEES Set Employee_DOB= '2001-02-28' where Employee_id=4110");
				stmt.executeUpdate("insert into EMPLOYEES values(4113,'Ashutosh','1997-05-30',116,'2017-11-11')");
				ResultSet rs=stmt.executeQuery("select * from EMPLOYEES");
				while(rs.next())
				System.out.println(rs.getInt("Employee_id")+" "+rs.getString("Employee_name")+" "+rs.getDate("Employee_DOB")+"   "+rs.getInt("Department_ID")+"  "+rs.getDate("DOJ"));
				con.close();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}