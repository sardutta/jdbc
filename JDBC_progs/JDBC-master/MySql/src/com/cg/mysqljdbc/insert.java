package com.cg.mysqljdbc;

import java.sql.*;

public class insert 
{
	public static void main(String []args)
	{
		PreparedStatement myStmnt = null;
		ResultSet myRes = null;
		try 
		{
			Connection myCon=  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","qwerty");
			//System.out.println("got connection");
			//create statement
			Statement mystmt = myCon.createStatement();
			
			myStmnt = myCon.prepareStatement("insert into employees(id,last_name,first_name,email,department,salary) values(?,?,?,?,?,?) ");

			 

			//Set the parameters 
			myStmnt.setInt(1,15);
			myStmnt.setString(2,"Sam");
			myStmnt.setString(3,"Stevense");
			myStmnt.setString(4,"stevesam@hotmail.com");
			myStmnt.setString(5,"senior Consultant");
			myStmnt.setDouble(6,80000);
			myStmnt.executeUpdate();
			myRes= mystmt.executeQuery("select * from employees");
			while(myRes.next())
			{
				String lastName = myRes.getString("last_name");
				String firstName = myRes.getString("first_name");
				double salary = myRes.getDouble("salary");
				String departments  = myRes.getString("department");
				System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
