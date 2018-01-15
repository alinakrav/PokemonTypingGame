import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/** 
 * This class is used to display text, and specifically for this task, user input.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Wordbox extends Actor
{
    String string = ""; // sring of this wordbox's text
    int size; // size of wordbox

    // constructor sets the image of the wordbox to given text of defined size
    public Wordbox(String s) {
        string = s;
        size = 30;
        //set text image
        GreenfootImage image = new GreenfootImage(string, size, Color.BLACK, Color.YELLOW);
        this.setImage(image);
    }   
}
