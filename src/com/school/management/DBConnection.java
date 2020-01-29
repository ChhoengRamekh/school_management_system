package com.school.management;
import java.sql.*;
import java.sql.DriverManager;
public class DBConnection {
	
    static final String driver = "com.mysql.jdbc.Driver";  
    static final String url = "jdbc:mysql://localhost:3306/school_management";
 
    static final String username = "root";
    static final String password = "";
    
	 public Connection getConnection() {
	  try{
	   Class.forName(driver);
	   Connection connection = DriverManager.getConnection(url,username,password);
	   return connection;
	  } catch(Exception e){System.out.println(e);}
	  
	  return null;
	 }
}
