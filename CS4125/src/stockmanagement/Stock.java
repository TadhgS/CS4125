package stockmanagement;

import java.util.HashMap;

public class Stock {

	private HashMap<Integer, Stockitem> stocklist;
	
	public Stock()
	{
		this.stocklist = new HashMap<Integer, Stockitem>();
	}
	
	public void addItem(Item item, int amount)
	{
		if(amount>=0)
		{
			if(this.stocklist.containsKey(item.getArtNr()))
			{
				this.stocklist.get(item.getArtNr()).addItem(amount);
			}
			else
			{
				Stockitem tempstock = new Stockitem(item);
				this.stocklist.put(item.getArtNr(), tempstock);
			}
		}
		else
		{
			System.out.println("ERROR: amount is negative");
		}
	}
	
	public void removeItem(Item item, int amount)
	{
		if(amount>0)
		{
			if(this.stocklist.containsKey(item.getArtNr()))
			{
				Stockitem tempstockitem = this.stocklist.get(item.getArtNr());
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
	
}
