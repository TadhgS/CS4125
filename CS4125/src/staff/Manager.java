package staff;

import java.util.ArrayList;

public class Manager extends Staffmember {
	Manager(){}// Default
	Manager(String anID , String aUsername, String aPassword) {
		super(anID , aUsername, aPassword);
	}
	
	// Employee Management
	public void add_Employee(Employee anEmployee, ArrayList<Employee> employees){
			employees.add(anEmployee);
	}
	public void remove_Employee(Employee anEmployee , ArrayList<Employee> employees){
			employees.remove(anEmployee);
	}
	
	// Reports
	public void get_reports(){}
	// Discounts 
	public void set_discounts(){}
}
