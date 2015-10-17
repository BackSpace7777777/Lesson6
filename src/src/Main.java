package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static JFrame frame=new JFrame("Lesson 6 - Main Menu");
    public static JButton menuButton;
    private static JButton employee,guessGame,patron;
    private static Employee e;
    private static GuessGame gg;
    private static PatronBook p;
    public static void main(String[] args) {
        frame.setSize(475,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        patron=new JButton();
        patron.setText("Patron Books");
        patron.setBounds(315,5,150,30);
        patron.setVisible(true);
        patron.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(false);
                p.visible(true);
            }
        });
        guessGame=new JButton();
        guessGame.setText("Guessing Game");
        guessGame.setBounds(160,5,150,30);
        guessGame.setVisible(true);
        guessGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(false);
                gg.visible(true);
            }
        });
        employee=new JButton();
        employee.setText("Employee");
        employee.setBounds(5,5,150,30);
        employee.setVisible(true);
        employee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                menu(false);
                e.visible(true);
            }
        });
        menuButton=new JButton();
        menuButton.setText("Main Menu");
        menuButton.setBounds(5,5,150,30);
        menuButton.setVisible(false); 
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu(true);
            }
        });
        e=new Employee();
        p=new PatronBook();
        gg=new GuessGame();
        frame.add(employee);
        frame.add(patron);
        frame.add(menuButton);
        frame.add(guessGame);
        frame.setVisible(true);
    }
    public static void menu(boolean tf)
    {
        e.visible(false);
        gg.visible(false);
        p.visible(false);
        frame.setSize(475,200);
        frame.setTitle("Lesson 6 - Main Menu");
        employee.setVisible(tf);
        guessGame.setVisible(tf);
        patron.setVisible(tf);
        if(tf)menuButton.setVisible(false);
        else menuButton.setVisible(true);
    }
}
