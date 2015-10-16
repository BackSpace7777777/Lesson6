package src.Objects;

import java.util.Random;

public class GuessMachine {
    private int guesses,number,playerNumber;
    private boolean won;
    private Random r;
    public GuessMachine()
    {
        guesses=0;
        won=false;
        r=new Random();
        number=r.nextInt(99)+1;
    }
    public String getHint()
    {
        String out="";
        if(won)
        {
            out="You have won!";
        }
        else
        {
            if(playerNumber>number)
            {
                out="You guessed " + playerNumber + " and is too high";
            }
            else if(playerNumber<number)
            {
                out="You guessed " + playerNumber + " and is too low";
            }
        }
        return out;
    }
    public boolean setGuess(int n)
    {
        if(n>0 && n<101)
        {
            playerNumber=n;
            if(n==number)won=true;
            else guesses++;
            return true;
        }
        else
        {
            return false;
        }
    }
    public int getAmountOfGuesses()
    {
        return guesses;
    }
    public void reset()
    {
        won=false;
        guesses=0;
        number=r.nextInt(99)+1;
    }
}
