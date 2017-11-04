import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class is going to display the word on the screen and move it
 * 
 * @ Kathy
 */
public class Word extends Actor
{
    private String string;

    public Word(String text, Color co)
    {
        string = text;
        // display the random word generated by the WordGenerator class
        GreenfootImage outImage = new GreenfootImage(text, 20 , Color.BLACK, co ); 
        this.setImage(outImage);
    }

    public void act()
    {
        moveWord();
    }

    // this method makes the word move
    public void moveWord()
    {
        int speed = 2;
        // the speed get be reset based on the levels & game features
        setLocation(getX() + speed, getY());

        if(getX() > getWorld().getWidth()-5){
            getWorld().removeObject(this);
        }
    }

    // this method returns the length of the word
    public int getWordLength()
    {
        return this.string.length();
    }

    // this method returns the word
    public String getString()
    {
        return string;
    }
}