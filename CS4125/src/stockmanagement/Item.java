package stockmanagement;

public class Item {

	private String brand;
	private String article;
	private int artNr;
	private double price;
	
	public Item(String brand, String article, int artNr, double price) 
	{
		this.brand=brand;
		this.article=article;
		this.artNr=artNr;
		this.price=price;
	}
	
	public String getBrand() 
	{
		return this.brand;
	}
	
	public String getArticle()
	{
		return this.article;
	}
	
	public int getArtNr()
	{
		return this.artNr;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
}
