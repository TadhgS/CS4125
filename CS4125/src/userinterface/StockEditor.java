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

import stockmanagement.Item;
import stockmanagement.Stock;

public class StockEditor 
{

	private JFrame frame;
	private JFormattedTextField tf_artNr, tf_price, tf_amount, tf_article, tf_brand;
	private Stock stock;
	private int artNr_old;
	
	public StockEditor(Item item)
	{
		stock = Stock.getStockInstance();
		artNr_old = item.getNr();
		ActionListener listen = new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						switch(e.getActionCommand())
						{
						case "back":
							GUIFactory.createGUIFactory().createStockChange("updateItem");
							frame.dispose();
							break;
						case "confirm":
							updateStock();
							break;
						}
						
					}
			
				};
		frame = new JFrame();
		frame.setSize(256, 256);
		frame.setLayout(new BorderLayout());
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridLayout(5,2));
		JLabel artNr = new JLabel("ArtNr:");
		JLabel article = new JLabel("Article:");
		JLabel brand = new JLabel("Brand:");
		JLabel price = new JLabel("Price:");
		JLabel amount = new JLabel("Amount:");
		tf_artNr = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
		tf_article = new JFormattedTextField();
		tf_brand = new JFormattedTextField();
		tf_price = new JFormattedTextField(NumberFormat.FRACTION_FIELD);
		tf_amount = new JFormattedTextField(NumberFormat.FRACTION_FIELD);
		tf_artNr.setText(String.valueOf(item.getNr()));
		tf_article.setText(item.getArticle());
		tf_brand.setText(item.getBrand());
		tf_price.setText(String.valueOf(item.getPrice()));
		tf_amount.setText(String.valueOf(item.getAmount()));
		mainpanel.add(artNr);
		mainpanel.add(tf_artNr);
		mainpanel.add(article);
		mainpanel.add(tf_article);
		mainpanel.add(brand);
		mainpanel.add(tf_brand);
		mainpanel.add(price);
		mainpanel.add(tf_price);
		mainpanel.add(amount);
		mainpanel.add(tf_amount);
		frame.add(mainpanel, BorderLayout.CENTER);
		JPanel menupanel = new JPanel();
		menupanel.setLayout(new GridLayout(1,2));
		JButton back = new JButton("back");
		back.addActionListener(listen);
		back.setActionCommand("back");
		JButton confirm = new JButton("confirm");
		confirm.addActionListener(listen);
		confirm.setActionCommand("confirm");
		menupanel.add(back);
		menupanel.add(confirm);
		frame.add(menupanel, BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	
	public void updateStock()
	{
		int artNr =Integer.valueOf(tf_artNr.getText());
		int amount = Integer.valueOf(tf_amount.getText());
		double price = Double.valueOf(tf_price.getText());
		String article = tf_article.getText();
		String brand = tf_brand.getText();
		this.stock.updateItem(artNr_old, artNr, amount, price, article, brand);
		frame.dispose();
		GUIFactory.createGUIFactory().createStockChange("updateItem");
	}

}
