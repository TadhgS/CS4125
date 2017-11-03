package userinterface;

/**
 * @author Daniel Keating
* @author 14159627
*/

import java.util.ArrayList;

public class Authentication 
{
    public static int level = 0;
    
    public static boolean authenticate(String username, String password) 
    {    
        File login = new File(1);
        ArrayList<String> Info = login.getFile();
	int check = Info.indexOf(username);
        if(check == -1)
        {
            return false;
        }
	if (password.equals(Info.get(check+=2))) 
        {
            level = Integer.parseInt(Info.get(check-=1));
            return true;
        }
    return false;
    }
}