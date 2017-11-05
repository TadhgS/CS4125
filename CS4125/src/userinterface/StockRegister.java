package userinterface;

import javax.swing.JFrame;

public class StockRegister implements StockChange{

	@Override
	public void updateStock() {
		// TODO Auto-generated method stub
		
	}
	
	public StockRegister()
	{
		JFrame frame = new JFrame("Register Item");
		frame.setSize(256, 256);
		frame.setVisible(true);
	}

}
