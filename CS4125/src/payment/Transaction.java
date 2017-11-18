package payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import customer.Customer;

public class Transaction extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton customerIDButton;
	private JTextField userText;
	private String customerID = "";
	private static int checkID;
	
	public Transaction()
	{
		setTitle("Customer ID");
        setLayout(null);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JLabel userLabel = new JLabel("Customer ID:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        customerIDButton = new JButton("Login");
        customerIDButton.setBounds(180, 80, 80, 25);
        customerIDButton.addActionListener(this);
        add(customerIDButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == customerIDButton)
        {
            customerID = userText.getText();
            checkID = Customer.customer(customerID);
            
            switch(checkID)
            {
            	case -1: JOptionPane.showMessageDialog(null, "No ID exists");//call to make random customer ID
            		break;
            	case 0: JOptionPane.showMessageDialog(null, "Not enough has been spent for a discount");
        			break;
            	case 1: //set discount to 10%
        			break;
            	case 2: //set discount to 15%
        			break;
            	case 3: //set discount to 20%
            		break;
            }
        }
	}
}
