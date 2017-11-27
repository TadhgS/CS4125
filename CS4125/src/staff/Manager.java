package staff;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends Staffmember {
	private ArrayList<Staffmember> staff;
	public Manager(){
		staff = new ArrayList<Staffmember>();
	}// Default Constructor
	Manager(String aUsername, String aPassword) {
		super(aUsername, aPassword);
		staff = new ArrayList<Staffmember>();
	}
	
	// Employee Management
	public boolean add_Employee(Employee anEmployee){
		boolean success = true;
		load_file();
		for(Staffmember s: staff){
			if(s.getUsername().matches(anEmployee.getUsername())){
				if(s.getPassword().matches(anEmployee.getUsername()))
					success = false;
			}
		}
		if(success){
			staff.add(anEmployee);
		}
		return success;
	}
	public boolean remove_Employee(Employee anEmployee){
		load_file();
		boolean found = false;
		for(Staffmember s: staff){
			if(s.getUsername().matches(anEmployee.getUsername())){
				if(s.getPassword().matches(anEmployee.getUsername()))
					staff.remove(s);
				found = true;
			}
		}
		return found;
	
	}
	public void view_Employees(){
		load_file();
	}
	
	// Reports
	public void get_reports(){}
	// Discounts 
	public void set_discounts(){}
	
	private void load_file(){
		String text = "";
		try {
			FileReader aFile = new FileReader("src./userinterface/loginDetail.txt");
			BufferedReader bf = new BufferedReader(aFile);
			while( (text = bf.readLine()) != null){
				String tempArr[] = text.split(",");
				
				staffFactory f = staffFactory.getStaffFactory();
				Staffmember temp;
				if(tempArr[1]=="1"){
				temp = f.createStaff("Employee");}
				else{
				temp = f.createStaff("Manger");
				}
				if(temp!=null){
				temp.setValues(tempArr[0],tempArr[2]);
				staff.add(temp);
				}
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}

