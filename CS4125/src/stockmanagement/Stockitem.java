package stockmanagement;

public class Stockitem {

	private String brand;
	private String article;
	private int artNr;
	private double price;
	private int stock;
	
	public Stockitem(int artNr, String brand, String article, double price, int amount)
	{
		this.artNr=artNr;
		this.brand=brand;
		this.article=article;
		this.price=price;
		this.stock=amount;
	}
	
	public void addItem(int amount)
	{
		this.stock+=amount;
	}
	
	public boolean removeItem(int amount)
	{
		if(this.stock>=amount)
		{
			this.stock-=amount;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean getItem(int amount)
	{
		if(this.stock>=amount)
		{
			this.stock-=amount;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getNr()
	{
		return this.artNr;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public String getArticle()
	{
		return this.article;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public int getAmount()
	{
		return this.stock;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}
	
	public boolean isEqual(Stockitem item)
	{
		if(item.article==this.article && item.brand==this.brand)
		{
			return true;
		}
		return false;
	}
	
}
