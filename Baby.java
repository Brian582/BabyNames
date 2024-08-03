/**
 * this class holds the Baby's name, rank, and number of babies with that same name
 */
public class Baby implements Comparable<Baby>
{
    private String babyName;//baby's name
    private int rank;//baby's rank
    private int nameAmount;//number of babies with that same name
    
    /**
     * Constructors for objects of class Baby
     */
    public Baby()
    {
        this.rank=0;
        this.babyName="";
        this.nameAmount=0;
    }
    
    public Baby(int rank, String babyName, int nameAmount)
    {
        this.rank=rank;
        this.babyName=babyName;
        this.nameAmount=nameAmount;
    }
    
    //sets Baby's names
    public void setBabyName(String Babyname)
    {
        babyName=Babyname;
    }
    
    //sets Baby's rank
    public void setBabyRank(int Rank)
    {
        rank=Rank;
    }
    
    //sets Name amount for the baby's name
    public void setNameAmount(int NameAmount)
    {
        nameAmount=NameAmount;
    }

    //returns Baby's names
    public String getBabyName()
    {
        return babyName;
    }
    
    //returns Baby's rank
    public int getBabyRank()
    {
        return rank;
    }
    
    //returns Name amount for the baby's name
    public int getNameAmount()
    {
        return nameAmount;
    }
    
    //compares the babies by name (this method is from Java class library)
    public int compareTo(Baby other)
    {
        int result = babyName.compareTo(other.babyName);
        return result; 
    }
    
    //shows Baby information
    public String toString()
    {
        return babyName + ":" + rank + ":" + nameAmount;
    }
}