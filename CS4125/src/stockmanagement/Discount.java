package stockmanagement;

public abstract class Discount implements Item {
	protected Item item;
	double amount;
	
	@Override
	public double getPrice() 
	{
		return item.getPrice()-this.amount;
	}

	@Override
	public double getAmount()
	{
		return this.amount;
	}

	@Override
	public boolean getItem(int amount) {
		return this.item.getItem(amount);
	}

	@Override
	public int getNr() {
		return this.item.getNr();
	}

	@Override
	public String getArticle() {
		return this.item.getArticle();
	}

	@Override
	public String getBrand() {
		return this.item.getBrand();
	}

	@Override
	public boolean removeItem(int amount) {
		return this.item.removeItem(amount);
	}
	
	@Override
	public void addItem(int amount) {
		this.item.addItem(amount);
	}

	@Override
	public void setValues(int amount, double price, String article, String brand) {
		this.item.setValues(amount, price, article, brand);
	}

	@Override
	public boolean isEqual(Item item) {
		return this.item.isEqual(item);
	}

	@Override
	public void setPrice(double price) {
		this.item.setPrice(price);
	}
	
}
