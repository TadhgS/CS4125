package stockmanagement;

import java.util.ArrayList;

public class Stockitem {

	private String brand;
	private String article;
	private int artNr;
	private double price;
	private int stock;
	
	public Stockitem(Item item)
	{
		this.artNr=item.getArtNr();
		this.brand=item.getBrand();
		this.article=item.getArticle();
		this.price=item.getPrice();
		this.stock=1;
	}
	
	public void addItem(int amount)
	{
		this.stock+=amount;
	}
	
	public void removeItem(int amount)
	{
		this.stock-=amount;
	}
	
	public Item getItem()
	{
		Item item = new Item(this.brand, this.article, this.artNr, this.price);
		return item;
	}
	
	public ArrayList<Item> getItem(int amount)
	{
		ArrayList<Item> templist = new ArrayList<Item>();
		for(int i=0;i<amount;i++)
		{
			Item item = new Item(this.brand, this.article, this.artNr, this.price);
			templist.add(item);
		}
		return templist;
	}
	
	public int getNr()
	{
		return this.artNr;
	}
	
	public int getAmount()
	{
		return this.stock;
	}
	
}
