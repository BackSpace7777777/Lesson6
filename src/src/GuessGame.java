package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import src.Objects.GuessMachine;

public class GuessGame extends Main{
    private JLabel enterNumberL,totalGuessL;
    private JTextField number,infoBox;
    private JButton submit;
    private GuessMachine gm;
    private boolean pa=false;
    public GuessGame()
    {
        gm=new GuessMachine();
        totalGuessL=new JLabel();
        totalGuessL.setText("Guesses so far: " + gm.getAmountOfGuesses());
        totalGuessL.setVisible(false);
        totalGuessL.setBounds(frame.getWidth()/2-75,130,150,30);
        enterNumberL=new JLabel();
        enterNumberL.setText("Enter a number between 1 and 100:");
        enterNumberL.setBounds(5,30,210,30);
        enterNumberL.setVisible(false);
        number=new JTextField();
        number.setBounds(210,31,100,30);
        number.setVisible(false);
        submit=new JButton();
        submit.setText("Submit");
        submit.setBounds(frame.getWidth()/2-75,65,150,30);
        submit.setVisible(false);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pa==false)
                {
                    try
                    {
                        if(gm.setGuess(Integer.parseInt(number.getText())))
                        {
                            totalGuessL.setText("Guesses so far: " + gm.getAmountOfGuesses());
                            if(gm.getHint().equals("You have won!"))
                            {
                                submit.setText("Play again");
                                pa=true;
                            }
                            infoBox.setText(gm.getHint());
                        }
                    }
                    catch(Exception ex){}
                }
                else
                {
                    gm.reset();
                    submit.setText("Submit");
                    pa=false;
                }
            }
        });
        infoBox=new JTextField();
        infoBox.setBounds(5,100,frame.getWidth()-15,30);
        infoBox.setEditable(false);
        infoBox.setVisible(false);
        frame.add(infoBox);
        frame.add(totalGuessL);
        frame.add(submit);
        frame.add(number);
        frame.add(enterNumberL);
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 6 - Guessing Game");
        enterNumberL.setVisible(tf);
        number.setVisible(tf);
        submit.setVisible(tf);
        totalGuessL.setVisible(tf);
        infoBox.setVisible(tf);
    }
}
