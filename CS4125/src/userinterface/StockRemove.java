package userinterface;

import javax.swing.JFrame;

public class StockRemove implements StockChange{

	@Override
	public void updateStock() {
		// TODO Auto-generated method stub
		
	}
	
	public StockRemove()
	{
		JFrame frame = new JFrame("Remove item");
		frame.setSize(256, 256);
		frame.setVisible(true);
	}
	
}
