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
	
	public void removeItem(int amount)
	{
		this.stock-=amount;
	}
	
	public Stockitem getItem(int amount)
	{
		Stockitem item = null;
		if(this.stock>=amount) 
		{
			item = new Stockitem(this.artNr, this.brand, this.article, this.price, amount);
			this.stock-=amount;
		}
		else
		{
			item = new Stockitem(this.artNr, this.brand, this.article, this.price, this.stock);
			this.stock-=this.stock;
			System.out.println("Item out of Stock");
		}
		return item;
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
	
}
