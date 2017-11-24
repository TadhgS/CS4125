package userinterface;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import payment.Transaction;

public class Gui 
{
	public static void main(String[] args) 
	{
		//add testcode here
	}
	
	public static void managerMenu(String empName) throws FileNotFoundException
    {
        String managerName;
        managerName = empName;
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog(null,"1: Make Sale \n 2: Log Out \n 3: Remove Employee \n 4: Add Stock","Welcome " + managerName, JOptionPane.PLAIN_MESSAGE));
        switch (x) {
            case 1:
                Transaction t = new Transaction();  
                break;
                //logOut();
            case 2:
                break;
                //removeEmployee();
            case 3:
                break;
                //addStock();
            case 4:
            	new StockMenu();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Invalid choice, Please enter 1 to make sale or 2 to log out, 3 to remove employee or 4 to add stock.");
                break;
        }
    }
    public static void employeeMenu(String empName) throws FileNotFoundException
    {
        String employeeName;
        employeeName = empName;
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog(null,"1: Make Sale \n 2: Log Out","Welcome " + employeeName, JOptionPane.PLAIN_MESSAGE));
        switch (x) {
            case 1:
                Transaction t = new Transaction();   
                break;
                //logOut();
            case 2:
                break;
            default:
                JOptionPane.showMessageDialog(null,"Invalid choice, Please enter 1 to make sale or 2 to log out");
                break;
        }
    }
	
}
