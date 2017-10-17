package stockmanagement;

import java.util.HashMap;

public class Stock {

	private HashMap<Integer, Stockitem> stocklist;
	
	public Stock()
	{
		this.stocklist = new HashMap<Integer, Stockitem>();
	}
	
	public void addItem(int artNr, String brand, String article, double price, int amount)
	{
		if(amount>=0)
		{
			if(this.stocklist.containsKey(artNr))
			{
				this.stocklist.get(artNr).addItem(amount);
			}
			else
			{
				Stockitem tempstock = new Stockitem(artNr, brand, article, price, amount);
				this.stocklist.put(artNr, tempstock);
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
		Stockitem item = this.stocklist.get(artNr).getItem(amount);
		if(item==null) 
		{
			System.err.println("ERROR: Stock empty");
			return null;
		}
		else 
		{
			return this.stocklist.get(artNr).getItem(amount);
		}
	}
	
}
