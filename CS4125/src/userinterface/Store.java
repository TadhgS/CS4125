package userinterface;

/**
 * @author Daniel Keating
* @author 14159627
*/

public class Store
{
    public static void main(String[] args) 
    {
        login();
    }

    public static void login()
    { 
        Login l = new Login();
        l.setVisible(true);
    }
    
    public static void employee()
    {
        System.out.print("Hello employee");
    }
        
    public static void manager()
    {
        System.out.print("Hello manager");
    }       
}