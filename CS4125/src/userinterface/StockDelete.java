package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import stockmanagement.Item;
import stockmanagement.Stock;

public class StockDelete implements StockChange{
	
	private Stock stock;
	private JFrame frame;
	private ArrayList<JCheckBox> checklist;
	private ActionListener listen;

	@Override
	public void updateStock() {
		for(int artNr : getSelected())
		{
			stock.deleteItem(artNr);
			refresh();
		}
	}
	
	public StockDelete()
	{		
		listen = new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						switch(arg0.getActionCommand())
						{
						case "back":
							new StockMenu();
							frame.dispose();
							break;
						case "delete":
							updateStock();
							break;
						}
					}
			
				};
			initializeDisplay();
		
	}
	
	private JPanel getItemView(Item item)
	{
		JPanel itemview = new JPanel();
		itemview.setLayout(new GridLayout(5,2));
		JLabel artNr1 = new JLabel();
		artNr1.setText("ArtNr:");
		JLabel artNr2 = new JLabel();
		artNr2.setText(String.valueOf(item.getNr()));
		JLabel name1 = new JLabel();
		name1.setText("Name:");
		JLabel name2 = new JLabel();
		name2.setText(item.getArticle());
		JLabel brand1 = new JLabel();
		brand1.setText("Brand:");
		JLabel brand2 = new JLabel();
		brand2.setText(item.getBrand());
		JLabel price1 = new JLabel();
		price1.setText("Price:");
		JLabel price2 = new JLabel();
		price2.setText(String.valueOf(item.getPrice()));
		JLabel amount1 = new JLabel();
		amount1.setText("amount:");
		JLabel amount2 = new JLabel();
		amount2.setText(String.valueOf(item.getAmount()));
		itemview.add(artNr1);
		itemview.add(artNr2);
		itemview.add(name1);
		itemview.add(name2);
		itemview.add(brand1);
		itemview.add(brand2);
		itemview.add(price1);
		itemview.add(price2);
		itemview.add(amount1);
		itemview.add(amount2);
		return itemview;
	}
	
	private ArrayList<Integer> getSelected()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(this.checklist!=null) 
		{
			for(JCheckBox box : this.checklist)
			{
				if(box.isSelected())
				{
					list.add(Integer.valueOf(box.getActionCommand()));
				}
			}
			return list;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void refresh() {
		this.stock=Stock.getStockInstance();
		initializeDisplay();
	}

	@Override
	public void initializeDisplay() {
		if(frame!=null)
		{
			frame.dispose();
		}
		this.checklist=new ArrayList<JCheckBox>();
		frame = new JFrame("Delete item");
		frame.setSize(256, 256);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		this.stock = Stock.getStockInstance();
		for(Map.Entry<Integer,Item> item : this.stock.getItemlist().entrySet())
		{
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1,2));
			panel.add(getItemView(item.getValue()));
			JCheckBox check = new JCheckBox();
			check.setActionCommand(String.valueOf(item.getKey()));
			this.checklist.add(check);
			panel.add(check);
			mainpanel.add(panel);
		}
		JScrollPane scroll = new JScrollPane(mainpanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll, BorderLayout.CENTER);
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(1,2));
		JButton back = new JButton("back");
		back.setActionCommand("back");
		back.addActionListener(listen);
		JButton delete = new JButton("delete");
		delete.setActionCommand("delete");
		delete.addActionListener(listen);
		menu.add(back);
		menu.add(delete);
		frame.add(menu, BorderLayout.PAGE_END);
	}
	
}
