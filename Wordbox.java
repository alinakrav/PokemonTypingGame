import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Wordbox extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String string = "";
    int size;
    public Wordbox(String s) {
        string = s;
        size = 30;
        //set text image
        GreenfootImage image = new GreenfootImage(string, size, Color.BLACK, Color.YELLOW);
        this.setImage(image);
    }   
}
