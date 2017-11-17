package stockmanagement;

public interface Item {

	public double getPrice();	
	public double getAmount();	
	public boolean getItem(int amount);
	public int getNr();
	public String getArticle();
	public String getBrand();
	public boolean removeItem(int amount);
	public void addItem(int amount);
	public void setValues(int amount, double price, String article, String brand);
	public boolean isEqual(Item item);
	public void setPrice(double price);
	
}
