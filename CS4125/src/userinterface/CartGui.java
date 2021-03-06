package userinterface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import customer.Shoppingcart;
import payment.Bill;
import stockmanagement.Stock;
import stockmanagement.Stockitem;

public class CartGui extends JFrame implements ActionListener
	{

	    private JTextField sName, quan;
	    private GridBagLayout layout;
	    private GridBagConstraints gbc;
	    private JButton addToCart, checkout, remove, cancel;
	    private JLabel lMessage, euro;
		public JLabel runningTotal;
		private JLabel stock;
		private JLabel quantity;
	    private JPanel panel;
	    private JTextArea shoppinglist;
	    private Stock s;

	    public CartGui() {
	        makeWindow();
	    }

	    public void makeWindow()
	    {
	        panel = new JPanel();
	        panel.setPreferredSize(new Dimension(800,250));
	        layout = new GridBagLayout();
	        gbc = new GridBagConstraints();
	        //Creating constraints and setting anchor and weight
	        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
	        gbc.insets = new Insets(2,2,2,2);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        layout.rowHeights = new int[] {50,50,50,50,50};
	        layout.columnWidths =new int[] {200,200,200,200};
	        panel.setLayout(layout);

	        stock = new JLabel("Please enter stock Item: ");
	        stock.setFont(new Font("", Font.PLAIN, 15));
	        sName = new JTextField(15);
	        quantity = new JLabel("Enter Quantity: ");
	        quantity.setFont(new Font("", Font.PLAIN, 15));
	        quan = new JTextField(15);
	        addToCart = new JButton("Add To Cart");
	        addToCart.setFont(new Font("", Font.PLAIN, 15));
	        checkout = new JButton("Check Out");
	        checkout.setFont(new Font("", Font.PLAIN, 15));
	        remove = new JButton("Remove Item from cart");
	        remove.setFont(new Font("", Font.PLAIN, 15));
	        cancel = new JButton("Cancel");
	        cancel.setFont(new Font("", Font.PLAIN, 15));
	        lMessage = new JLabel("");
	        euro = new JLabel("Euro: ");
	        euro.setFont(new Font("", Font.PLAIN, 15));
	        runningTotal = new JLabel("N/A");
	        shoppinglist = new JTextArea();
	        shoppinglist.setEditable(false);
	        //Add the stock label to panel
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(stock , gbc);
	        //Add the sName textfield to panel
	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(sName , gbc);
	        //Add the quantity label to panel
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(quantity , gbc);
	        //Add the quan textfiend to panel
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(quan , gbc);
	        //Add the addToCart button to panel
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(addToCart , gbc);
	        //Add the checkout button to panel
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(checkout , gbc);
	        //Add the remove button to panel
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(remove , gbc);
	        //Add the cancel button to panel
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(cancel , gbc);
	        //Add the lMessage textfield to panel
	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 2;
	        panel.add(lMessage , gbc);
	        //Add the euro textfield to panel
	        gbc.gridx = 2;
	        gbc.gridy = 4;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(euro , gbc);
	        //Add the runningTotal textfield to panel
	        gbc.gridx = 3;
	        gbc.gridy = 4;
	        gbc.gridheight = 1;
	        gbc.gridwidth = 1;
	        panel.add(runningTotal , gbc);
	        //Add the shoppingList textarea to panel
	        gbc.gridx = 2;
	        gbc.gridy = 0;
	        gbc.gridwidth = 2;
	        gbc.gridheight = 4;
	        gbc.fill = GridBagConstraints.BOTH;
	        panel.add(shoppinglist , gbc);

	        //Add panel to Frame
	        //this.getContentPane().add(BorderLayout.WEST, panel);
	        //this.getContentPane().add(BorderLayout.EAST, panel1);
	        //this.setLayout(new GridLayout(1,2));
	        this.add(panel);
	        //this.add(panel1);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setTitle("Cart");
	        this.setResizable(false);
	        this.setVisible(true);
	        this.pack();

	        addToCart.addActionListener(this);
	        checkout.addActionListener(this);
	        remove.addActionListener(this);
	        cancel.addActionListener(this);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	    	if (e.getSource() == addToCart)
	    	{
	    		int no =  Integer.parseInt(sName.getText());
	    		int amount = Integer.parseInt(quantity.getText());
	    		boolean inStock;
	    		Stockitem item;
				double price = 0;
				Shoppingcart cart = new Shoppingcart();
				cart.notifyObs();
	    
	    	}
	    }
}

