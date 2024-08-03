import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BabyNames
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //multi dimensional arrays to store baby data from the files
        Baby[][] BoyBabies= new Baby[28][1000];
        Baby[][] GirlBabies= new Baby[28][1000];
        
        String[] file= {"names1990.csv", "names1991.csv","names1992.csv","names1993.csv","names1994.csv",
                        "names1995.csv", "names1996.csv","names1997.csv","names1998.csv","names1999.csv",
                        "names2000.csv", "names2001.csv","names2002.csv","names2003.csv","names2004.csv",
                        "names2005.csv", "names2006.csv","names2007.csv","names2008.csv","names2009.csv",
                        "names2010.csv", "names2011.csv","names2012.csv","names2013.csv","names2014.csv",
                        "names2015.csv", "names2016.csv","names2017.csv"};
        
        ReadBabyFile bFile;
        
        //reads the files
        for(int i=0; i<28; i++)
        {
            bFile = new ReadBabyFile(file[i]);
            bFile.ReadFile();
            
            BoyBabies[i]=bFile.getBabyBoyArray();//gets BoyBaby Array
            GirlBabies[i]=bFile.getBabyGirlArray();//gets GirlBaby Array
            
        }
        
        System.out.println("Baby Boy Names data from the files");
        
        int y = 1990;//initialized with the year of the first file
        String year="";
        
        //sorts the BoyBabies array and prints it out
        for(int i=0; i<28; i++)
        {    
            year=String.valueOf(y);
            Arrays.sort(BoyBabies[i]);
            System.out.printf("Year %s: %s" , year , Arrays.toString(BoyBabies[i]));
            System.out.println();
            y+=1;
        }
          
        System.out.println("\nBaby Girl Names data from the files");
        y = 1990;//initializes the year again to 1990
        
        //sorts the GirlBabies array and prints it out
        for(int i=0; i<28; i++)
        {
            year=String.valueOf(y);
            Arrays.sort(GirlBabies[i]);
            System.out.printf("Year %s: %s" , year , Arrays.toString(GirlBabies[i]));
            System.out.println();
            y+=1;
        }
        
        System.out.println();
        
        //these sets will be used to detect duplicate names in the file
        HashSet<String> BoySet= new HashSet<String>();
        HashSet<String> GirlSet= new HashSet<String>();
        
        //adds baby names to a set 
        for(int r=0;r<28;r++)
        {
            for(int c=0;c<1000;c++)
            {
                //checks if boy names is already in the set
                if(BoySet.add(BoyBabies[r][c].getBabyName())==false)
                    BoySet.add(BoyBabies[r][c].getBabyName());
                    
                //checks if girl names is already in the set
                if(GirlSet.add(GirlBabies[r][c].getBabyName())==false)
                    GirlSet.add(GirlBabies[r][c].getBabyName());
            }
        }
        
        //Converts the sets into lists
        ArrayList<String> BoyNamesList = new ArrayList<String>(BoySet);
        ArrayList<String> GirlNamesList = new ArrayList<String>(GirlSet);
        
        //sorts the lists
        Collections.sort(BoyNamesList); 
        Collections.sort(GirlNamesList);
        
        //Prints out the BabyBoyNames list
        System.out.println("Baby Boy Names: " + BoyNamesList.toString() );
        System.out.println("Total number of Baby Boy Names: " + BoyNamesList.size() );
        System.out.println();
        
        //Prints out the BabyGirlNames list
        System.out.println("Baby Girl Names: " + GirlNamesList.toString() ); 
        System.out.println("Total number of Baby Girl Names: " + GirlNamesList.size() );
        System.out.println();
    }
}