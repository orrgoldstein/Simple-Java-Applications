package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfStudents;
		
		//ask hot many new students we want to add
		System.out.print("Enter number of new students to enroll: ");
		numOfStudents = in.nextInt();
		Student[] students = new Student[numOfStudents];
		
		//create n number of new students
		for (int i = 0; i < numOfStudents; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
			System.out.println(students[i].toString());
		}
	}
}
