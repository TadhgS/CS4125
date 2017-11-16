package userinterface;

/**
 * @author Daniel Keating
* @author 14159627
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class File 
{
    private int FileType;
    
    public File(int aType)
    {
        FileType = aType;
    }
    
    public ArrayList<String> getFile()
    {
        ArrayList<String> myList = new ArrayList<>();
        String fileToParse = "";
	
        switch(FileType)
        {
        	case 1: fileToParse = "./src/userinterface/loginDetail.txt";
        		break;
        	case 2: fileToParse = "./src/userinterface/customerDetail.txt";
        		break;
        }
        
        BufferedReader fileReader = null;
         
        try
        {
            String line = "";
            
            fileReader = new BufferedReader(new FileReader(fileToParse));
             
            
            while ((line = fileReader.readLine()) != null)
            {
                
                String[] tokens = line.split(",");
                myList.addAll(Arrays.asList(tokens));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                fileReader.close();
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return myList;
    }
}