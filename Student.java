package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	//constructor
	public Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("Enter student class level: \n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior");
		this.gradeYear = in.nextInt();
			
		setStudentID();
		}
	
	//generateID
	private void setStudentID() {
		//grade level + ID
		this.id ++;
		this.studentID = this.gradeYear + "" + this.id;
	}
	
	//enroll in courses
	public void enroll() {		
		//get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to quite):");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				this.courses = this.courses + "\n  " + course;
				this.tuitionBalance = this.tuitionBalance + this.costOfCourse;
			} else {
				break;
			}
		} while (1 != 0);
	}
	
	//view balance
	public void viewBalance() {
		System.out.println("YOUR BALANCE IS: $" + this.tuitionBalance);
	}
	
	//pay tuition
	public void payTuition() {
		viewBalance();
		Scanner in = new Scanner(System.in);
		int payment;
		System.out.println("Enter your payment: ");
		payment = in.nextInt();
		this.tuitionBalance = this.tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	//show status
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName +
				"\nGrade Level: " + this.gradeYear +
				"\nStudent ID: " + this.studentID +
				"\nCourses Enrolled: " + this.courses + 
				"\nBalance: " + this.tuitionBalance; 
	}
}
