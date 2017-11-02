package factory;

import customer.Customer;
import customer.Shoppingcart;
import machinelearning.Machinelearning;
import payment.Bill;
import payment.Transaction;
import scanner.ShopScanner;
import staff.Employee;
import staff.Manager;
import staff.Staffmember;
import stockmanagement.Stock;
import stockmanagement.Stockitem;

public class Factory {

	private static Factory factInstance;
	
	private Factory() 
	{
		
	}
	
	public static synchronized Factory getFactory()
	{
		if(Factory.factInstance==null)
		{
			Factory.factInstance = new Factory();
		}
		return Factory.factInstance;
	}
	
	public Staffmember getStaff(String type)
	{
		switch(type)
		{
			case "Employee":
				return new Employee();
			case "Manager":
				return new Manager();
			default:
				return null;
		}
	}
	
	public Stockitem getItem(int artNr, String brand, String article, double price, int amount)
	{
		return new Stockitem(artNr, brand, article, price, amount);
	}
	
	public Stock getStock()
	{
		return Stock.getStockInstance();
	}
	
	public Customer getCustomer()
	{
		return new Customer();
	}
	
	public Shoppingcart getShoppingCart()
	{
		return new Shoppingcart();
	}
	
	public Bill getBill()
	{
		return new Bill();
	}
	
	public Transaction getTransaction()
	{
		return new Transaction();
	}
	
	public ShopScanner getScanner()
	{
		return new ShopScanner();
	}
	
	public Machinelearning getMachine()
	{
		return new Machinelearning();
	}
}
