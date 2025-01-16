package com.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.Student;

public class studentcontroller {
	
	Scanner sc = new Scanner(System.in);

	public static Connection Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_event", "root", "0808");
		return con;



}

	public void registerforEvent()throws ClassNotFoundException, SQLException {
		Student student=new Student();
		System.out.println("Add Student Account");
		System.out.println("Enter student details,id,name,age,strem,eventtype");
		student.setStudentid(sc.nextInt());
		student.setStuname(sc.next());
		student.setAge(sc.nextInt());
		student.setStream(sc.next());
		student.setEventtype(sc.next());
		
		int id=student.getStudentid();
		String name=student.getStuname();
		int age=student.getAge();
		String stream=student.getStream();
		String eventtype=student.getEventtype();
		
		Statement stm = Connection().createStatement();
		String query = " insert into event values('" + id + "','" + name + "','" + age + "','" + stream + "','" + eventtype  + "')";
		stm.execute(query);
		System.out.println("Data saved Successfully");
		System.out.println("-------------------------------------------------------------------------");

	}
		
		
	

	public void filterstudentbyeventtype()throws ClassNotFoundException, SQLException { 
		displayallstudent();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_event", "root", "0808");
		
		System.out.println("Enter event type to filter students:");
	    String eventtype = sc.next();
	    boolean found = false;

	   
	    CallableStatement cs = con.prepareCall("{call selectData()}");
	
	    ResultSet rs = cs.executeQuery();

	    while (rs.next()) {
	    	if(eventtype.equals(rs.getString("Eventtype"))) {
	        found = true;
	        System.out.println("Student ID: " + rs.getInt("id"));
	        System.out.println("Name: " + rs.getString("name"));
	        System.out.println("Age: " + rs.getInt("age"));
	        System.out.println("Stream: " + rs.getString("stream"));
	        System.out.println("Event Type: " + rs.getString("Eventtype"));
	        System.out.println("-------------------------------------------------");
	        break;
	        
	    }

	    }

	    if(!found) {
	        System.out.println("No students found for the event type: " );
	    }

	}


	public void filterstudentbyname()throws ClassNotFoundException, SQLException { 
		displayallstudent();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_event", "root", "0808");
		
		System.out.println("Enter name  to filter students:");
	    String name = sc.next();
	    boolean found = false;

	    CallableStatement cs = con.prepareCall("{call selectData()}");
	
	    ResultSet rs = cs.executeQuery();
	    
	    while (rs.next()) {
	    	if(name.equals(rs.getString("name"))) {
	        found = true;
	        System.out.println("Student ID: " + rs.getInt("id"));
	        System.out.println("Name: " + rs.getString("name"));
	        System.out.println("Age: " + rs.getInt("age"));
	        System.out.println("Stream: " + rs.getString("stream"));
	        System.out.println("Event Type: " + rs.getString("Eventtype"));
	        System.out.println("-------------------------------------------------");
	        break;
	        
	    }

	    }

	    if(!found) {
	        System.out.println("No students found for name: " );
	    }

	}
		
		
		
	

	public void countstudentforspecificevent()throws ClassNotFoundException, SQLException { 
		displayallstudent();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_event", "root", "0808");
		
		System.out.println("count student by event:");
		String eventtype = sc.next();
		boolean count = false;
		int countnum = 0;
		
		 CallableStatement cs = con.prepareCall("{call selectData()}");
			
		    ResultSet rs = cs.executeQuery();
		    
		    while (rs.next()) {
		    	if (eventtype.equals(rs.getString("Eventtype"))){
		   
				
		        count = true;
				countnum++;
		        
		    }
		    }
	
	
		    if(!count) {
		        System.out.println("No students found for name: " );
		    }
		    System.out.println("Total count :"+countnum);
		    System.out.println("---------------------------------------");

		}
			
		


	public void displayallstudent() throws ClassNotFoundException, SQLException { 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_event", "root", "0808");
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println("-------------------------------------------------");

		}

	}

	
		
	}
