package customer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import payment.Observer;
import userinterface.CartGui;


public class Shoppingcart implements Subject
{

	private ArrayList<Observer> observers;
	private double price;
	private CartGui cart;
	
	public Shoppingcart()
	{
		observers = new ArrayList<Observer>();
		cart = new CartGui();
	}
	public void setPrice(double price1)
	{
		price = price1;
	}

	@Override
	public void register(Observer o) 
	{
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) 
	{
		int observerIndex = observers.indexOf(o);
		JOptionPane.showMessageDialog(null, "Observer Deleted.");
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObs()
	{
		price = Double.parseDouble(cart.runningTotal.getText());
		for(Observer observer : observers)
		{
			observer.update(price);
		}
		
	}
	

}
