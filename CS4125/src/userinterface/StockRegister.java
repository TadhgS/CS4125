package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stockmanagement.Stock;

public class StockRegister implements StockChange{
	
	private Stock stock;
	private JFrame frame;
	private JFormattedTextField tf_price, tf_amount, tf_article, tf_brand, tf_artNr;

	@Override
	public void updateStock() {
		if(tf_price.getText()!="" && tf_amount.getText()!="" && tf_article.getText()!="" && tf_brand.getText()!="" && tf_artNr.getText()!="")
		{
			double price = Double.valueOf(tf_price.getText());
			String article=tf_article.getText(), brand=tf_brand.getText();
			int artNr=Integer.valueOf(tf_artNr.getText()), amount=Integer.valueOf(tf_amount.getText());
			stock.registerItem(artNr,brand,article,price,amount);
		}
	}
	
	public StockRegister()
	{
		this.stock=Stock.getStockInstance();
		
		ActionListener listen = new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						switch(arg0.getActionCommand())
						{
						case "back":
							new StockMenu();
							frame.dispose();
							break;
						case "register":
							updateStock();
							break;
						}
					}
			
				};
		
		frame = new JFrame("Register Item");
		frame.setSize(256, 256);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.add(getItemFormular(), BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JButton back = new JButton("back");
		back.setActionCommand("back");
		back.addActionListener(listen);
		JButton register = new JButton("register");
		register.setActionCommand("register");
		register.addActionListener(listen);
		panel.add(back);
		panel.add(register);
		frame.add(panel, BorderLayout.PAGE_END);
		
	}
	
	private JPanel getItemFormular()
	{
		JPanel itemview = new JPanel();
		itemview.setLayout(new GridLayout(5,2));
		JLabel artNr1 = new JLabel();
		artNr1.setText("ArtNr:");
		tf_artNr = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
		JLabel name1 = new JLabel();
		name1.setText("Name:");
		tf_article = new JFormattedTextField();
		JLabel brand1 = new JLabel();
		brand1.setText("Brand:");
		tf_brand = new JFormattedTextField();
		JLabel price1 = new JLabel();
		price1.setText("Price:");
		tf_price = new JFormattedTextField(NumberFormat.FRACTION_FIELD);
		JLabel amount1 = new JLabel();
		amount1.setText("Amount:");
		tf_amount = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
		itemview.add(artNr1);
		itemview.add(tf_artNr);
		itemview.add(name1);
		itemview.add(tf_article);
		itemview.add(brand1);
		itemview.add(tf_brand);
		itemview.add(price1);
		itemview.add(tf_price);
		itemview.add(amount1);
		itemview.add(tf_amount);
		return itemview;
	}

}
