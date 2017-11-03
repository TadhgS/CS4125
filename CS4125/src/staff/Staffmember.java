package staff;


public abstract class Staffmember {
	private String ID;
	private String username;
	private String password;
	// Default Constructor
	Staffmember(){}
	Staffmember( String anID , String aUsername , String aPassword){
		ID       = anID;
		username = aUsername;
		password = aPassword;
	}
	
	// Get Methods
	public String getID()      {return ID ;}
	public String getUsername(){ return username; }
	public String getPassword(){ return password; }
	
	// View Stock
	public void viewStock(){}
	
	// Account Actions
	public void login(){}
	public void logout(){}

}
