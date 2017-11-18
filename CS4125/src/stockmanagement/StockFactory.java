package stockmanagement;

public class StockFactory {

	public static StockFactory stockinstance;
	
	private StockFactory() {};
	
	public static StockFactory getStockFactory()
	{
		if(stockinstance==null)
		{
			return new StockFactory();
		}
		else
		{
			return stockinstance;
		}
	}
	
	public Item createItem(int artNr, String brand, String article, double price, int amount)
	{
		return new Stockitem(artNr, brand, article, price, amount);
	}
	
	public Item createDiscount(Item article, String type, double value)
	{
		switch(type)
		{
		case "percentual":
			return new Percentual(article, value);
		case "fixedvalue":
			return new FixedValue(article, value);
		default:
			return null;
		}
	}
	
	public Stock createStock()
	{
		return Stock.getStockInstance();
	}
	
}
