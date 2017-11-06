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

import stockmanagement.Stockitem;

public class StockEditor 
{

	private JFrame frame;
	
	public StockEditor(Stockitem item)
	{
		ActionListener listen = new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						switch(e.getActionCommand())
						{
						case "back":
							frame.dispose();
							GUIFactory.factInstance.createStockChange("updateItem");
							break;
						case "confirm":
							updateStock();
							break;
						}
						
					}
			
				};
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridLayout(5,2));
		JLabel artNr = new JLabel("ArtNr:");
		JLabel article = new JLabel("Article:");
		JLabel brand = new JLabel("Brand:");
		JLabel price = new JLabel("Price:");
		JLabel amount = new JLabel("Amount:");
		JFormattedTextField tf_artNr = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
		JFormattedTextField tf_article = new JFormattedTextField();
		JFormattedTextField tf_brand = new JFormattedTextField();
		JFormattedTextField tf_price = new JFormattedTextField(NumberFormat.FRACTION_FIELD);
		JFormattedTextField tf_amount = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
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
		JButton back = new JButton();
		back.addActionListener(listen);
		back.setActionCommand("back");
		JButton confirm = new JButton();
		confirm.addActionListener(listen);
		confirm.setActionCommand("confirm");
		menupanel.add(back);
		menupanel.add(confirm);
		frame.add(menupanel, BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	
	public void updateStock()
	{
		frame.dispose();
		GUIFactory.createGUIFactory().createStockChange("updateItem");
	}

}
