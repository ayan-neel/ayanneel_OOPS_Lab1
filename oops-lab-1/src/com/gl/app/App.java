package com.gl.app;

import java.util.Scanner;

import com.gl.model.Employee;
import com.gl.service.CredentialService;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String department=null;
		Employee emp = new Employee("Rupesh","Jha");
		CredentialService cs = new CredentialService();
		boolean flag=true;
		while(flag) {
			System.out.println("Please enter the department from the following: \n1. Technical\n2. Admin\n3. Legal\n4. Human Resource");
			System.out.print("Your choice:");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					department="Technical";
					flag=false;
					break;
				case 2:
					department="Admin";
					flag=false;
					break;
				case 3:
					department="Legal";
					flag=false;
					break;
				case 4:
					department="Human Resource";
					flag=false;
					break;
				default:
					System.out.println("Invalid option! please enter correct choice");
					break;
			}
		}
		String emailId = cs.generateEmailAddress(emp.getFirstName(),emp.getLastName(),department);
		String password = cs.generatePassword();
		String message="Dear %s your generated credentials are as follows\nEmail-----> %s\nPassword---->%s";
		String formattedMessage = String.format(message, emp.getFirstName(),emailId,password);
		System.out.println(formattedMessage);
		
		
		

	}

}
