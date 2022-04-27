package application;
import java.sql.*;
public class DatabaseConnection{
	public Connection dataLink;
	public Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/inventorymanagement";
		String user="root";
		String pass="@2Google2@";
	try {
		dataLink=DriverManager.getConnection(url,user,pass);	
	}
	catch(Exception e) {
		e.printStackTrace();
		e.getCause();
	}
	return dataLink;
}
}