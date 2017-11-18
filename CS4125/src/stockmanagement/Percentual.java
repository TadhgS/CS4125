package stockmanagement;

public class Percentual extends Discount {

	public Percentual(Item item, double percent) {
		this.item=item;
		if(percent<1)
		{
			this.amount=item.getPrice()*percent;
		}
		else 
		{
			this.amount=0;
		}
	}

}
