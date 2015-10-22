package src;

import javax.swing.JTextArea;
import src.Objects.Book;
import src.Objects.Patron;

public class PatronBook extends Main{
    private JTextArea con;
    private Book[] books=new Book[5];
    private Patron[] patrons=new Patron[5];
    private String displayString;
    public PatronBook()
    {
        displayString="Books Available:\n======================\n";
        books[0]=new Book("From Russia With Love","Greg Hines");
        books[1]=new Book("Living Smart","Rita Langill");
        books[2]=new Book("Singing in the Rain","Harry Conner");
        books[3]=new Book("Good House Keeping","Pat Burns");
        books[4]=new Book("To Be a Model","Lisa Lahey");
        for(int i=0;i<books.length;i++)displayString+=books[i].getNameOfBook() + "\n";
        displayString+="======================\n";
        patrons[0]=new Patron("John Cena",books);
        displayString+=bookTaking(patrons[0],books[1]) + '\n';
        displayString+=patrons[0].hasBooksOut();
        con=new JTextArea();
        con.setBounds(5,40,frame.getWidth()-15,750-70);
        con.setEditable(false);
        con.setText(displayString);
        con.setVisible(false);
        frame.add(con);
    }
    private String bookReturn(Patron p,Book b)
    {
        int bookI=0;
        for(int i=0;i<books.length;i++)
        {
            if(books[i]==b)
            {
                bookI=i;
                break;
            }
        }
        if(p.takeOut(bookI))
        {
            return b.getNameOfBook() + " was returned " + p.getName();
        }
        else
        {
            return b.getNameOfBook() + " was not returned";
        }
    }
    private String bookTaking(Patron p,Book b)
    {
        int bookI=0;
        for(int i=0;i<books.length;i++)
        {
            if(books[i]==b)
            {
                bookI=i;
                break;
            }
        }
        if(p.takeOut(bookI))
        {
            return b.getNameOfBook() + " was taken out by " + p.getName();
        }
        else
        {
            return b.getNameOfBook() + " was not taken out";
        }
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 6 - Patron Books");
        frame.setSize(frame.getWidth(),750);
        con.setVisible(tf);
    }
}
