package staff;

public abstract class Staffmember {
	private String username;
	private String password;
	// Default Constructor
	Staffmember(){}
	Staffmember(String aUsername , String aPassword){
		username = aUsername;
		password = aPassword;
	}
	public void setValues(String aUsername , String aPassword){
		username = aUsername;
		password = aPassword;
	}
	// Get Methods
	public String getUsername(){ return username; }
	public String getPassword(){ return password; }
	
	// View Stock
	public void viewStock(){}
	
	// Account Actions
	public void login(){}
	public void logout(){}
}
