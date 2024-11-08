package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String LastName;
	private String password;
	private String Department;
	private int mailboxcapacity=100;
	private int defaultpasswordLength=10;
	private String email;
	private String alternateEmail;
	private String CompanySuffix ="onmeridian.com";
	
	// Constructor to receive the First name and Last name
		public Email(String firstName, String LastName) {
			this.firstName = firstName;
			this.LastName = LastName;
			System.out.println("Email created : " + this.firstName +" " + this.LastName);
			
			// call a method and asking for the department - return the department
			this.Department = setDepartment();
			System.out.println("Department: "+ this.Department);
			//call a method that returns a random password
			this.password = randomPassword(defaultpasswordLength);
			System.out.println("Your Password is: "+ this.password);
			// combine to get Email
			email = firstName.toLowerCase()+"." + LastName.toLowerCase() + "@" + Department + "." + CompanySuffix;
           // System.out.println("Your Email is: " + email);		
		}
	// Ask for the department
		private String setDepartment() {
			System.out.print("New Employee: " + firstName +".DepartmentCodes: \n1 for sales\n2 for development\n3 for counting\n0 for none\nEnter Department Code: ");
			Scanner scn = new Scanner(System.in);
			int depChoice = scn.nextInt();
			if(depChoice==1) {return "sales";}		
			else if (depChoice==2) {return "dev";} 
			else if(depChoice==3) {return "acct";}
			else {return "";
			}
			}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random()* passwordSet.length());
			password[i]= passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
	//Set the mailbox capacity
	 public void setmailboxcapacity(int Capacity) {
		 this.mailboxcapacity = Capacity;
	 }
	 public void setalternateEmail(String altemail) {
		 this.alternateEmail = altemail;
	 }
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}
			public int getmailboxcapacity(){ return mailboxcapacity;}
			public String getalternateEmail() { return alternateEmail;}
			public String getPassword() { return password;}
			
			public String showInfo() {
				return "DISPLAY NAME: " + firstName +" " + LastName + "\nCompanyEmail: " +email
						+ "\nMailboxcapacity: " + mailboxcapacity + "Gb";
			}
}
