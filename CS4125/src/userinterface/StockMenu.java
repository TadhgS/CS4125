package userinterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StockMenu {

	private ActionListener stocklisten;
	private JFrame frame;
	private GUIFactory fact;
	
	public StockMenu()
	{
		this.stocklisten = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
				fact.createStockChange(arg0.getActionCommand());
			}
			
		};
		this.fact = GUIFactory.createGUIFactory();
		this.frame = new JFrame("Testframe");
		this.frame.setSize(256, 128);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton addItem = new JButton("Add item");
		addItem.addActionListener(this.stocklisten);
		addItem.setActionCommand("addItem");
		JButton registerItem = new JButton("Register item");
		registerItem.addActionListener(this.stocklisten);
		registerItem.setActionCommand("registerItem");
		JButton removeItem = new JButton("Remove item");
		removeItem.addActionListener(this.stocklisten);
		removeItem.setActionCommand("removeItem");
		this.frame.setLayout(new GridLayout(3,1));
		this.frame.add(registerItem);
		this.frame.add(addItem);
		this.frame.add(removeItem);
	}
	
}
