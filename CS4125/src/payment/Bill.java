package payment;

import javax.swing.JOptionPane;

import customer.Subject;

public class Bill implements  Observer
{
	 
	 private Subject Shoppingcart;

	 public Bill(Subject shoppingcart)
	 {
		         this.Shoppingcart = shoppingcart;
		         shoppingcart.register(this);
	 }

	public void update(double price) 
	{
		JOptionPane.showMessageDialog(null, "Your RFID has been charged: " + price + "/n Thank you and please shop with us again.");
		
	}

}
