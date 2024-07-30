import java.sql.*;

import java.util.Scanner;

public class second3
{
public static void main(String[] args)
 {

Connection conn = null;
CallableStatement cst = null;

String url = "jdbc:mysql://localhost:3306/hp";

Scanner scanner = new Scanner(System.in);

System.out.print("Enter employee ID: ");
String empFirstName = scanner.nextLine();

try {

conn = DriverManager.getConnection(url, "root","tnrao");


cst = conn.prepareCall("{call f_selre(?, ?)}");

cst.setString(1, empFirstName);



cst.execute();

String designa = cst.getString(2);
System.out.println("Design is: " + designa);

cst.close();
conn.close();

}
catch (Exception e)
{
e.printStackTrace();
}

}
}
