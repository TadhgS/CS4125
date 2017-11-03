package staff;


public class Manager extends Staffmember {
	Manager(){}// Default Constructor
	Manager(String anID , String aUsername, String aPassword) {
		super(anID , aUsername, aPassword);
	}
	
	// Employee Management
	public void add_Employee(Employee anEmployee){
	}
	public void remove_Employee(Employee anEmployee){
	}
	public void view_Employees(){}
	
	// Reports
	public void get_reports(){}
	// Discounts 
	public void set_discounts(){}
	
}

