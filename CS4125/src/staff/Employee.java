package staff;

public class Employee extends Staffmember {
	Employee(){} // Default constuctor
	Employee(String anID , String aUsername, String aPassword) {
		super(anID , aUsername, aPassword);
	}
}
