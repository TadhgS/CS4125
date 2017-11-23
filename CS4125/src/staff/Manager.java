package staff;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends Staffmember {
	private ArrayList<Staffmember> staff;
	public Manager(){}// Default Constructor
	Manager(String aUsername, String aPassword) {
		super(aUsername, aPassword);
		staff = new ArrayList<Staffmember>();
	}
	
	// Employee Management
	public void add_Employee(Employee anEmployee){
		load_file();
	}
	public void remove_Employee(Employee anEmployee){
		load_file();
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
			FileReader aFile = new FileReader("./userinterface/loginDetail.txt");
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
				temp.setValues(tempArr[0],tempArr[2]);
				staff.add(temp);
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}

