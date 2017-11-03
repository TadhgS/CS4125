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
	
	public Staffmember createStaff(String type)
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
	
	public Stockitem createItem(int artNr, String brand, String article, double price, int amount)
	{
		return new Stockitem(artNr, brand, article, price, amount);
	}
	
	public Stock createStock()
	{
		return Stock.getStockInstance();
	}
	
	public Customer createCustomer()
	{
		return new Customer();
	}
	
	public Shoppingcart createShoppingCart()
	{
		return new Shoppingcart();
	}
	
	public Bill createBill()
	{
		return new Bill();
	}
	
	public Transaction createTransaction()
	{
		return new Transaction();
	}
	
	public ShopScanner createScanner()
	{
		return new ShopScanner();
	}
	
	public Machinelearning createMachine()
	{
		return new Machinelearning();
	}
}
