package stockmanagement;

import java.util.HashMap;

public class Stock {
	
	private static Stock stockInstance;
	private StockFactory fact;

	private HashMap<Integer, Item> stocklist;
	
	private Stock()
	{
		fact = StockFactory.getStockFactory();
		this.stocklist = new HashMap<Integer, Item>();
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
			Item item = this.stocklist.get(artNr);
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
				Item tempstockitem = this.stocklist.get(artNr);
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
	
	public Item getItem(int artNr, int amount)
	{
		if(this.stocklist.containsKey(artNr))
		{
			Item item = this.stocklist.get(artNr);
			if(item!=null)
			{
				if(item.getItem(amount)==true)
				{
					return fact.createItem(item.getNr(),item.getBrand(),item.getArticle(),item.getPrice(),amount);
				}
				else
				{
					double fullstock = item.getAmount();
					System.err.println("ERROR: Item out of stock, returned " + fullstock + " items");
					if(item.removeItem((int)fullstock)==true)
					{
						return fact.createItem(item.getNr(), item.getBrand(), item.getArticle(), item.getPrice(), (int)fullstock);
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
	
	public HashMap<Integer, Item> getItemlist()
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
	
	public Item getItem(int artNr)
	{
		return this.stocklist.get(artNr);
	}
	
	public void updateItem(int artNr_old, int artNr, int amount, double price, String article, String brand)
	{
		Item item = this.stocklist.get(artNr_old);
		if(item!=null)
		{
			if(artNr_old==artNr)
			{
				item.setValues(amount, price, article, brand);
			}
			else
			{
				if(this.stocklist.containsKey(artNr))
				{
					System.err.println("ERROR: Article Number not Valid");
				}
				else
				{
					this.stocklist.remove(artNr_old);
					this.registerItem(artNr, brand, article, price, amount);
				}
			}
		}
		else
		{
			System.err.println("ERROR: Item not found");
		}
	}
	
	private boolean validateStock(Item item)
	{
		for(HashMap.Entry<Integer, Item> temp : this.stocklist.entrySet())
		{
			if(temp.getValue().isEqual(item))
			{
				System.err.println("ERROR: Item already exists with artNr" + temp.getValue().getNr());
				return false;
			}
		}
		return true;
	}
	
	public void addDiscount(int artNr, String discount, double value)
	{
		Item item = this.stocklist.get(artNr);
		if(item!=null)
		{
			Item tempitem = this.fact.createDiscount(item, discount, value);
			this.stocklist.replace(artNr, tempitem);
		}
	}
	
	public void removeDiscount(int artNr)
	{
		Item item = this.stocklist.get(artNr);
		if(item!=null)
		{
			Item tempitem = this.fact.createItem(item.getNr(), item.getBrand(),  item.getArticle(),  item.getPrice(), (int)item.getAmount());
			this.stocklist.replace(artNr, tempitem);
		}
	}
	
}
