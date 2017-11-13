package customer;

import java.util.ArrayList;
import userinterface.File;

public class Customer 
{
	public static int customer(String customerID)
	{
		File Desc = new File(2);
		ArrayList<String> loadedCustomers = Desc.getFile();
		
		int check = loadedCustomers.indexOf(customerID);
		
		if(check == -1)
		{
			return -1;
		}
		else
		{
			String spent = "";
			spent.equals(loadedCustomers.get(check += 1));
			double value = Double.parseDouble(spent);
		
			if(value >= 100.00 || value <= 199.99)
			{
				return 1;
			}
			else if(value >= 200.00 || value <= 299.99)
			{
				return 2;
			}
			else if(value > 300.00)
			{
				return 3;
			}
			else
				return 0;
		}
	}
}