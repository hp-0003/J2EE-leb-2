import java.sql.*;
import java.util.Scanner;

public class second4
 {
public static void main(String[] args)
 {
Connection conn = null;
CallableStatement cst = null;
ResultSet rs = null;
String url = "jdbc:mysql://localhost:3306/hp";

Scanner scanner = new Scanner(System.in);

System.out.print("Enter employee design: ");
String de = scanner.nextLine();

try {

conn = DriverManager.getConnection(url, "root", "tnrao");


cst = conn.prepareCall("{call p_selnm(?)}");

cst.setString(1, de);

boolean hasResults = cst.execute();

if (hasResults)
 {
rs = cst.getResultSet();
if (rs.next())
 {
int  empno = rs.getInt("ename");
String fname = rs.getString("fname");
String lname = rs.getString("lname");
String des = rs.getString("design");

System.out.println("Employee's ID is: " + empno);
System.out.println("Employee's first name is: " + fname);
System.out.println("Employee's last name is: " + lname);
System.out.println("Employee's designation name is: " + des);

} 
else {
System.out.println("No employee data find: " );
}
}

rs.close();
cst.close();
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
scanner.close();
}
}
