package com.viwe;

import java.sql.SQLException;
import java.util.Scanner;



import com.controller.studentcontroller;


public class studentviwe {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
	
		studentcontroller s = new studentcontroller();
		studentcontroller.Connection();


		while (true) {

			System.out.println("\t 1:  register for event");
			System.out.println("\t 2:filter student by event type");
			System.out.println("\t 3:filter student by name");
			System.out.println("\t 4: count student for specific event");
			System.out.println("\t 5: display all student");
			System.out.println("\t 6: Exit");
			System.out.println("----------------------------------------------------------------------");

			System.out.println("choice an option.....:");
			int choice = sc.nextInt();
			
			switch (choice) {

			case 1:
				s.registerforEvent();
				break;

			case 2:
				s.filterstudentbyeventtype();
				break;

			case 3:
				s.filterstudentbyname();
				break;

			case 4:
				s.countstudentforspecificevent();
				break;

			case 5:
				s.displayallstudent();
				break;

			case 6:
				System.exit(choice);
				break;
			}

}
}
	
}