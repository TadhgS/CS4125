package userinterface;

import javax.swing.JFrame;

public class StockAdd implements StockChange{

	@Override
	public void updateStock() {
		// TODO Auto-generated method stub
		
	}
	
	public StockAdd()
	{
		JFrame frame = new JFrame("Add item");
		frame.setSize(256, 256);
		frame.setVisible(true);
	}

}
