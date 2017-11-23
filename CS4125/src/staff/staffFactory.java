package staff;

import stockmanagement.StockFactory;

public class staffFactory {
	public static staffFactory staffInstance;
	
	private staffFactory(){};
	
	public static staffFactory getStaffFactory(){
		if(staffInstance==null)
		{
			return new staffFactory();
		}
		else
		{
			return staffInstance;
		}
	}
	
	public Staffmember createStaff(String type){
		if(type == "Employee"){
			return new Employee();
		}else if(type == "Manager"){
			return new Manager();
		}else {
			return null;
		}
	}
}
