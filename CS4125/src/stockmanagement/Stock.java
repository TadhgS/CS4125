package stockmanagement;

import java.util.HashMap;

import factory.Factory;

public class Stock {
	
	private static Stock stockInstance;
	private Factory fact;

	private HashMap<Integer, Stockitem> stocklist;
	
	private Stock()
	{
		fact = Factory.getFactory();
		this.stocklist = new HashMap<Integer, Stockitem>();
	}
	
	public static synchronized Stock getStockInstance()
	{
		if(Stock.stockInstance==null)
		{
			Stock.stockInstance = new Stock();
		}
		return stockInstance;
	}
	
	public void registerItem(int artNr, String brand, String article, double price, int amount)
	{
		if(amount>=0)
		{
			if(this.stocklist.containsKey(artNr))
			{
				System.err.println("ERROR: artNr is already in use");
			}
			else
			{
				Stockitem tempstock = new Stockitem(artNr, brand, article, price, amount);
				if(validateStock(tempstock))
				{
					this.stocklist.put(artNr,  tempstock);
				}
			}
		}
		else
		{
			System.out.println("ERROR: amount is negative");
		}
	}
	
	public void addItem(int artNr, int amount)
	{
		if(this.stocklist.containsKey(artNr)) {
			Stockitem item = this.stocklist.get(artNr);
			if(amount>0) {
				item.addItem(amount);
			}
			else
			{
				System.err.println("ERROR: amount negative or zero");
			}
		}
		else
		{
			System.err.println("ERROR: Item not found");
		}
	}
	
	public void removeItem(int artNr, int amount)
	{
		if(amount>0)
		{
			if(this.stocklist.containsKey(artNr))
			{
				Stockitem tempstockitem = this.stocklist.get(artNr);
				if(tempstockitem.getAmount()>=amount)
				{
					tempstockitem.removeItem(amount);
				}
			}
		}
		else
		{
			System.err.println("ERROR: amount is 0 or negative");
		}
	}
	
	public void deleteItem(int artNr)
	{
		if(this.stocklist.containsKey(artNr))
		{
			this.stocklist.remove(artNr);
		}
		else
		{
			System.err.println("ERROR: Item not found");
		}
	}
	
	public Stockitem getItem(int artNr, int amount)
	{
		if(this.stocklist.containsKey(artNr))
		{
			Stockitem item = this.stocklist.get(artNr);
			if(item!=null)
			{
				if(item.getItem(amount)==true)
				{
					return fact.createItem(item.getNr(),item.getBrand(),item.getArticle(),item.getPrice(),amount);
				}
				else
				{
					int fullstock = item.getAmount();
					System.err.println("ERROR: Item out of stock, returned " + fullstock + " items");
					if(item.removeItem(fullstock)==true)
					{
						return fact.createItem(item.getNr(), item.getBrand(), item.getArticle(), item.getPrice(), fullstock);
					}
					else
					{
						System.err.println("ERROR: removing non existent items from Stockitem");
						return null;
					}
				}
			}
			else
			{
				System.err.println("ERROR: item == null");
				return null;
			}
		}
		else
		{
			return null;
		}
	}	
	
	public HashMap<Integer, Stockitem> getItemlist()
	{
		if(this.stocklist!=null)
		{
			return this.stocklist;
		}
		else
		{
			return null;
		}
	}
	
	public Stockitem getItem(int artNr)
	{
		return this.stocklist.get(artNr);
	}
	
	private boolean validateStock(Stockitem item)
	{
		for(HashMap.Entry<Integer, Stockitem> temp : this.stocklist.entrySet())
		{
			if(temp.getValue().isEqual(item))
			{
				System.err.println("ERROR: Item already exists with artNr" + temp.getValue().getNr());
				return false;
			}
		}
		return true;
	}
	
}
