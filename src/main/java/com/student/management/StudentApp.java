package com.student.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.sql.*;

import com.database.DBConnection;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

public class StudentApp {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Connection conn=new DBConnection().DBConnect();

	synchronized public void addStudentInfo() throws NumberFormatException, IOException, SQLException
	{
		 
						 System.out.println("id..");
						 int sId=Integer.parseInt(br.readLine());
				
						 System.out.println("Enter Student Name.");
						 String studentName=br.readLine();
						 
						 System.out.println("Student gender..");
						 String studentGender=br.readLine();
						 
						 System.out.println("Enter Student Address.");
						 String studentAd=br.readLine();
						 
						 System.out.println("Enter Student Class.");
						 String studentClass=br.readLine();
						 
						 System.out.println("Enter Student Contact.");
						 long studentNo=Long.parseLong(br.readLine());
						 
						 System.out.println("Enter Email");
						 String sEmail=br.readLine();
						 
						PreparedStatement stmt=conn.prepareStatement("insert into studentInfo values(?,?,?,?,?,?,?)");
						stmt.setInt(1, sId);
						stmt.setString(2, studentName);
						stmt.setString(3, studentGender);
						stmt.setString(4, studentAd);
						stmt.setString(5, studentClass);
						stmt.setLong(6, studentNo);
						stmt.setString(7, sEmail);
						
						if(stmt.executeUpdate()>0)
						{
							System.out.println("student information added");
						}
						else
						{
							System.out.println("something went wrong...");
						}
						 
				 }
				

	synchronized public void viewAllStudentInfo() throws NumberFormatException, IOException, SQLException
	{
		
		
		System.out.println("=================================================================================");
		 java.sql.Statement st=conn.createStatement();
		// PreparedStatement pst=conn.prepareStatement("select * from student where studentId=?");
		 ResultSet result=st.executeQuery("select * from studentInfo");
		 //pst.setInt(1, sid);
		 
		 if(conn!=null)
		 {
			 while(result.next())
			 {
				 System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getLong(6)+" "+result.getString(7));
			 }
		 }
		 else
			 System.out.println("No records are founded...");
		
		System.out.println("================================================================================");
	}
	
	
	
	synchronized public void deleteStudentInfoById() throws NumberFormatException, IOException, SQLException {
	  
		System.out.println("enter student id.."); 
		int sid=Integer.parseInt(br.readLine());
	  
			try { 
				if(conn!=null) 
				{ 
					PreparedStatement stmt=conn.prepareStatement("delete from studentInfo where studentId=?");
						stmt.setInt(1, sid);
	  
						if(stmt.executeUpdate()>0)
							System.out.println("Record deleted from student table"); 
						else
							System.out.println("Record not Deleted");
	  
				}
				else System.out.println("Not connected"); } 
			catch (SQLException e) {
	  
					System.out.println("Problem in connection!!"); } 
	
			}
	
	  synchronized public void updateStudentInfoById() throws NumberFormatException, IOException, SQLException {
		  System.out.println("enter student id.."); 
		  int sid=Integer.parseInt(br.readLine());
		  
		  System.out.println("Enter Student Name."); 
		  String studentName=br.readLine();
		  
		  System.out.println("enter student gender..");
		  String sGender=br.readLine();
	  
		  System.out.println("Enter Student Address."); 
		  String studentAd=br.readLine();
	  
		  System.out.println("Enter Student Class."); 
		  String studentClass=br.readLine();
	  
		  System.out.println("Enter Student Contact."); 
		  long studentNo=Long.parseLong(br.readLine());
		  
		  System.out.println("Enter mail");
		  String smail=br.readLine();
	  
		  try {
			  	if(conn!=null) 
			  	{
			  		PreparedStatement stmt=conn. prepareStatement("update studentInfo set studentName=?,gender=?,studentAddress=?,studentClass=?,studentContact=?,studentEmail=? where studentId=?"); 
			  		stmt.setString(1, studentName); 
			  		stmt.setString(2, sGender);
			  		stmt.setString(3, studentAd);
			  		stmt.setString(4, studentClass); 
			  		stmt.setLong(5, studentNo); 
			  		stmt.setString(6, smail);
			  		stmt.setInt(7, sid);
	  
			  		if(stmt.executeUpdate()>0)
			  		{
			  			System.out.println("Updated successfully..");
			  		}
			  		else { 
			  			System.out.println("Record not updated"); 
			  			}
			  	}
			  	else {
			  		System.out.println("Not connected"); } 
			  	} 
		  catch (SQLException e) {
	  
			  			System.out.println("Problem in connection!!"); 
			  		}
	  
	  catch (Exception e) {
	  
	  System.out.println("Something went worng!!"); }
	  
	   }
	synchronized public void deleteAllStudentInfo()
	{
		System.out.println("========================================================");
		try
		{
			if(conn!=null)
			{
				PreparedStatement stmt=conn.prepareStatement("delete from studentInfo");
				if(stmt.executeUpdate()>0)
				{
					System.out.println("Successfully deleted .");
				}
				else
					System.out.println("not deleted");
			}
			else
			{
				System.out.println("Not Connected");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Problem in connection");
		}
		catch(Exception e)
		{
			System.out.println("something went wrong");
		}
		System.out.println("=======================================================");
	}

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("=================================================");
		System.out.println("------------Student Management System----------------");
		System.out.println("=======================================================");
		String ch=null;
		StudentApp app=new StudentApp();
		do
		{
			System.out.println("\t\t1)Insert Student Information\n"
					+"\t\t2)View All Student Information\n"
					+"\t\t3)Update Student Information by ID\n"
					+"\t\t4)Delete Student Information by ID\n"
					+"\t\t5)Delete All Student Information");
			System.out.println("=======================================================");
			System.out.println("Enter Your Choice....");
			int choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:app.addStudentInfo();
				break;
			case 2:app.viewAllStudentInfo();
				break;
			case 3:app.updateStudentInfoById();
				break;
			case 4:app.deleteStudentInfoById();
				break;
			case 5:app.deleteAllStudentInfo();
				break;
			default :System.out.println("Wrong Choic...");
			}
			System.out.println("Do you want to continue?(Y->Yes/N->No)");
			ch=br.readLine();
		}
		while(ch.equals("Y")||ch.equals("y"));
		System.out.println("==================================================");
		System.out.println("Bye.....");
		System.out.println("===========================");		
 
	}

}
