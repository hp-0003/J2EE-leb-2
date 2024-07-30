import java.sql.*;
public class second5{
private static final String URL = "jdbc:mysql://localhost:3306/hp";
private static final String USER = "root";
private static final String PASSWORD = "tnrao";
public static void main(String[] args) {
// Testing CRUD operations
createEmployee("John", "Doe", "clerk");
readEmployee(1);
updateEmployee(1, "Jane", "Doe", "abc");
deleteEmployee(1);
}
// Create
public static void createEmployee(String fname, String lname, String design) {
String sql = "INSERT INTO emp (fname, lname, design) VALUES (?, ?, ?)";
try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement pstmt = conn.prepareStatement(sql)) {
pstmt.setString(1, fname);
pstmt.setString(2, lname);
pstmt.setString(3, design);
pstmt.executeUpdate();
System.out.println("Employee created successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
}
// Read
public static void readEmployee(int ename) {
String sql = "SELECT * FROM emp WHERE ename = ?";
try {
Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, ename);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
System.out.println("ID: " + rs.getInt("ename"));
System.out.println("First Name: " + rs.getString("fname"));
System.out.println("Last Name: " + rs.getString("lname"));
System.out.println("Designation: " + rs.getString("design"));
}
} catch (SQLException e) {
e.printStackTrace();
}
}
// Update
public static void updateEmployee(int ename, String fname, String lname, String design) {
String sql = "UPDATE emp SET fname = ?, lname = ?, design = ? WHERE ename = ?";
try
{
Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, fname);
pstmt.setString(2, lname);
pstmt.setString(3, design);
pstmt.setInt(4, ename);
pstmt.executeUpdate();
System.out.println("Employee updated successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
}
// Delete

public static void deleteEmployee(int ename) {
String sql = "DELETE FROM emp WHERE ename = ?";
try {
Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, ename);
pstmt.executeUpdate();
System.out.println("Employee deleted successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
}
}
