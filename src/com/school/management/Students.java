package com.school.management;
import java.sql.*;

public class Students {
    private String id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private String province;
    private int phone_number;
	
	public static void main(String [] args) {
		Students student = new Students();
		
		//student.create_data("Sovanna", "Doung", "Female",22, "SovannaDoung@gmail.com", "Siem Reap","096787838", "23/12/1998");
		//student.update_data("Ramekh", "CHHOENG", "Male",21 , "ChhoengRamekhs@gmail.com", "Siem Reap","0978188183", "06/08/1999", 4);
		student.view_data(6);
		//student.delete_data(5);
		student.read_data();
	}
	
	public void read_data() {
		DBConnection obj_DB_Connection = new DBConnection();
		Connection connection = obj_DB_Connection.getConnection();
		try {
			PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM students");
            
            ResultSet data = prepStatement.executeQuery();
			
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%8s %15s %15s %15s %5s %25s %15s %15s %15s", "STUDENT-ID", 
            		"FIRST NAME", "LAST NAME", "GENDER","AGE", "EMAIL","PROVINCE","PHONE-NUMBER", "DATE-OF-BIRTH\n");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
         
            
            while(data.next()) {
            	System.out.format("%10s %15s %15s %15s %5s %25s %15s %15s %15s",
                        data.getString("id"), data.getString("first_name"), data.getString("last_name"), 
                        data.getString("gender"), data.getLong("age"), data.getString("email"), 
                        data.getString("province"), data.getString("phone"), data.getString("date_of_birth"));
                System.out.println();
                
            }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void view_data(int stuid) {
		DBConnection obj_DB_Connection = new DBConnection();
		Connection connection = obj_DB_Connection.getConnection();
		try {
			String query = "SELECT * FROM students WHERE id = ?";
			PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setLong(1, stuid);
            ResultSet data = prepStatement.executeQuery();
			
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%8s %15s %15s %15s %5s %25s %15s %15s %15s", "STUDENT-ID", 
            		"FIRST NAME", "LAST NAME", "GENDER","AGE", "EMAIL","PROVINCE","PHONE-NUMBER", "DATE-OF-BIRTH\n");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
         
            
            while(data.next()) {
            	System.out.format("%10s %15s %15s %15s %5s %25s %15s %15s %15s",
                        data.getString("id"), data.getString("first_name"), data.getString("last_name"), 
                        data.getString("gender"), data.getLong("age"), data.getString("email"), 
                        data.getString("province"), data.getString("phone"), data.getString("date_of_birth"));
                System.out.println();
                
            }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void create_data(String first_name,String last_name,String gender, int age, 
			String email, String province, String phone, String date_of_birth) {
		DBConnection obj_DB_Connection = new DBConnection();
		Connection connection = obj_DB_Connection.getConnection();
		
		try {
			String query = "INSERT INTO Students("
					+ "first_name,last_name, gender, age, email, province, phone, date_of_birth"
					+ ") values (?,?,?,?,?,?,?,?)";
			PreparedStatement prepStatement = connection.prepareStatement(query);
			prepStatement.setString(1, first_name);
			prepStatement.setString(2, last_name);
			prepStatement.setString(3, gender);
			prepStatement.setLong(4, age);
			prepStatement.setString(5, email);
			prepStatement.setString(6, province);
			prepStatement.setString(7, phone);
			prepStatement.setString(8, date_of_birth);
			System.out.println(prepStatement);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update_data(String first_name,String last_name,String gender, int age, 
			String email, String province, String phone, String date_of_birth, int stuid) {
		DBConnection obj_DB_Connection = new DBConnection();
		Connection connection = obj_DB_Connection.getConnection();
		
		try {
			String query = "UPDATE Students SET "
					+ "first_name = ?,last_name = ?, gender = ?, age = ?, "
					+ "email = ?, province = ?, phone = ?, date_of_birth = ? WHERE id = ? ";
			PreparedStatement prepStatement = connection.prepareStatement(query);
			prepStatement.setString(1, first_name);
			prepStatement.setString(2, last_name);
			prepStatement.setString(3, gender);
			prepStatement.setLong(4, age);
			prepStatement.setString(5, email);
			prepStatement.setString(6, province);
			prepStatement.setString(7, phone);
			prepStatement.setString(8, date_of_birth);
			prepStatement.setLong(9, stuid);
			System.out.println(prepStatement);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete_data(int stuid) {
		DBConnection obj_DB_Connection = new DBConnection();
		Connection connection = obj_DB_Connection.getConnection();
		
		try {
			String query = "DELETE FROM Students WHERE id = ?";
			PreparedStatement prepStatement = connection.prepareStatement(query);
			prepStatement.setLong(1, stuid);
			prepStatement.executeUpdate();
			System.out.println(prepStatement);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
