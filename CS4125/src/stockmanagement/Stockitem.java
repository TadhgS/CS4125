package stockmanagement;

public class Stockitem implements Item{

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
	
	@Override
	public void addItem(int amount)
	{
		this.stock+=amount;
	}
	
	@Override
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
	
	@Override
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
	
	@Override
	public int getNr()
	{
		return this.artNr;
	}
	
	@Override
	public String getBrand()
	{
		return this.brand;
	}
	
	@Override
	public String getArticle()
	{
		return this.article;
	}
	
	@Override
	public double getPrice()
	{
		return this.price;
	}
	
	@Override
	public double getAmount()
	{
		return this.stock;
	}
	
	@Override
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	@Override
	public boolean isEqual(Item item)
	{
		if(this.article.equals(item.getArticle()) && this.brand.equals(item.getBrand()))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void setValues(int amount, double price, String article, String brand)
	{
		this.stock=amount;
		this.price=price;
		this.article=article;
		this.brand=brand;
	}

}
