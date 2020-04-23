package com.cg.mysqljdbc;

import java.sql.*;

public class JdbcDriver 
{
	public static void main(String args[])
	{
		//get connection to the database
		try 
		{
			Connection mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","3733");
			//create a statement
			Statement stmt= mycon.createStatement();
			//execute sql query
			String sql= "insert into books(BookNum,BookName,AuthorName) values(007,'James Bond','KG')";
			stmt.executeUpdate(sql);
			//String sqldel=
			//process the resultset
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				System.out.println(rs.getString("BookName")+" "+rs.getString("AuthorName"));
			}
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
