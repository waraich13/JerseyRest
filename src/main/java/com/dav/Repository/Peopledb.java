package com.dav.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dav.JerseyRest.People;

public class Peopledb {


	public Peopledb() throws Exception {
		getConnection();
	}


	public void addPeople(String person) throws Exception {
		
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO PEOPLE VALUES ('"+person+"')");
			posted.executeUpdate();

			System.out.println("People Added!");
			
			
			
		}catch(Exception e) {System.out.println(e);}
		finally {
		}
	}
	
	
	public  ArrayList<People> getPeople() throws SQLException, ClassNotFoundException{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM PEOPLE order by name");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<People> people = new ArrayList<People>();
			while(result.next()) {
				System.out.println(result.getString("Name"));
				
				People p = new People();
				p.setName(result.getString("Name"));
				
				
				people.add(p);
				}
			System.out.println("All records added");
			return people;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	


	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;	
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost; databaseName=eclipsejava; integratedSecurity=true;trustServerCertificate=true";
		Class.forName(driver);
		con = DriverManager.getConnection(url);
		try {
			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}

