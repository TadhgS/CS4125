package staff;

public abstract class Staffmember {
	private String ID;
	private String username;
	private String password;
	// Default Constuctor
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
	
	// Update Stock
	public void updateStock(){}
	
	// Account Actions
	public void login(){}
	public void logout(){}
}
