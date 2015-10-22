package src.Objects;
public class Book {
    private boolean isTaken;
    private String nameOfBook,author;
    private int index;
    private String[] takenLog;
    public Book(String bookName,String author)
    {
        isTaken=false;
        index=0;
        takenLog=new String[1];
        nameOfBook=bookName;
        this.author=author;
    }
    public String getTakenOutBy()
    {
        return takenLog[takenLog.length-1];
    }
    public boolean takeOut(String name)
    {
        if(isTaken)
        {
            return false;
        }
        else
        {
            try
            {
                takenLog[index]=name;
            }
            catch(Exception ex)
            {
                addToLog();
                takenLog[index]=name;
            }
            isTaken=true;
            return true;
        }
    }
    public boolean returnBook(String name)
    {
        if(isTaken)
        {
            isTaken=false;
            index++;
            try
            {
            takenLog[index]=name;
            }
            catch(Exception ex)
            {
                addToLog();
                takenLog[index]=name;
            }
            index++;
            return true;
        }
        else
        {
            return false;
        }
    }
    public String getAuthor()
    {
        return author;
    }
    public String getNameOfBook()
    {
        return nameOfBook;
    }
    public String[] BookLog()
    {
        return takenLog;
    }
    private void addToLog()
    {
        String[] temp=new String[takenLog.length+1];
        for(int i=0;i<takenLog.length;i++)
        {
            temp[i]=takenLog[i];
        }
        takenLog=new String[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            takenLog[i]=temp[i];
        }
    }
}
