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
	
        if(FileType == 1)
        {
            fileToParse = "loginDetail.txt";
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