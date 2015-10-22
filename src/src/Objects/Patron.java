package src.Objects;
public class Patron {
    private Book[] bookList;
    private String name;
    public Patron(String name,Book[] list)
    {
        bookList=list;
        this.name=name;
    }
    public boolean takeOut(int book)
    {
        boolean out=true;
        out=bookList[book].takeOut(name);
        return out;
    }
    public boolean returnBook(int book)
    {
        boolean out=true;
        out=bookList[book].returnBook(name);
        return out;
    }
    public String getName()
    {
        return name;
    }
    public String hasBooksOut()
    {
        String out="";
        for(int i=0;i<bookList.length;i++)
        {
            if(bookList[i].getTakenOutBy().equals(name))
            {
                out+=bookList[i].getNameOfBook() + "\n";
            }
        }
        return out;
    }
}
