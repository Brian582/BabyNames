import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads the file for Baby information
 */
public class ReadBabyFile
{
    private String filename;
    private Baby[] BabyBoyArray = new Baby[1000];
    private Baby[] BabyGirlArray = new Baby[1000];
    
    /**
     * Constructor gets the file's name
     */
    public ReadBabyFile(String filename)
    {
        this.filename = filename;
    }

    /**
     * Reads the baby file
     */
    public void ReadFile() throws FileNotFoundException
    {        
        int number=0; //used to get numbers from the file
        String name=""; //used to get names from the file
        int i=0; 
        
        String directory = System.getProperty("user.dir"); //gets path of the current directory
        directory += "/BabyFiles/"; //adds the folder to the path  
        File readFile= new File(directory,filename); //reads file from the folder
        Scanner in = new Scanner(readFile);
        
        //reads each line in the file until the end
        while(in.hasNextLine())
        {
            String line=in.nextLine();//gets a line from the file
            int col=0;//used to count each string in line, refering to them by columns from the file
            int start=0;//used to hold positon of character for the next string in the line  
            int p=0;
            
            //initializes the Baby objects
            BabyBoyArray[i]= new Baby();
            BabyGirlArray[i]= new Baby();
            
            //reads in a line
            while(p<line.length())
            {
                char c=line.charAt(p);
                
                while(c!=',')//goes through each character until it reaches a comma
                {
                    p++;//increases for next character
                    
                    if(p==line.length())//reaches the end of the line, the end of the line won't have a comma
                    {
                        break;
                    }
                    
                    c=line.charAt(p);//gets next character   
                }
                
                if(col==0)//this would be the baby's rank 
                {
                    number = Integer.parseInt(line.substring(0,p));//changes string to int
                    BabyBoyArray[i].setBabyRank(number);
                    BabyGirlArray[i].setBabyRank(number);
                }
         
                else if(col==1)//this would be the baby boy name 
                {
                    name = line.substring(start,p);//gets name from file
                    BabyBoyArray[i].setBabyName(name);
                }
                
                else if(col==2)//this would be the baby boy name amount
                {
                    number = Integer.parseInt(line.substring(start,p));
                    BabyBoyArray[i].setNameAmount(number);
                }
                
                else if(col==3)//this would be the baby girl name 
                {
                    name = line.substring(start,p);
                    BabyGirlArray[i].setBabyName(name);
                }
                
                else if(col==4)//this would be the baby girl name amount
                {
                    number = Integer.parseInt(line.substring(start,p));
                    BabyGirlArray[i].setNameAmount(number);
                }
         
                p=p+1;//goes to next character after comma
                start=p;//holds place of the character for the next string
                col++;
                        
                //increase index for next object in each array
                if(col==5)
                {
                    i++;
                }   
            }         
        } 
    }
    
    //returns BabyBoyArray array
    public Baby[] getBabyBoyArray()
    {
        return BabyBoyArray;
    }
    
    //returns BabyGirlArray array
    public Baby[] getBabyGirlArray()
    {
        return BabyGirlArray;
    }
}