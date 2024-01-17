package com.stingray.hidesandskins;
import java.sql.*;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/hidesandskins", "joshua","JoshuA13!");
			Statement stmt = con.createStatement();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
