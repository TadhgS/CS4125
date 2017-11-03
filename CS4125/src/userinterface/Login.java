package userinterface;

/**
 * @author Daniel Keating
* @author 14159627
*/

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    private static boolean security;
    private JButton loginButton;
    private JTextField userText;
    private JPasswordField passwordText;
    private String userName = "";
    private String userPass;
    
    public Login()
    {
        setTitle("The Shop");
        setLayout(null);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(180, 80, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == loginButton)
        {
            userName = userText.getText();
            char[] Pass = passwordText.getPassword();
            userPass = new String(Pass);
            security = Authentication.authenticate(userName, userPass);
            if (security == false)
            {
                JOptionPane.showMessageDialog(null, "Incorrect Username/Password", "Alert", JOptionPane.ERROR_MESSAGE);
                
            }
            else
            {		
                if (Authentication.level == 1)
                {
                    setVisible(false);
                    //send to employee screen
                    Store.employee();
                }
                
                if (Authentication.level == 2)
                {
                    setVisible(false);
                    //send to manager screen
                    Store.manager();
                }
            }
	  }
   }
}