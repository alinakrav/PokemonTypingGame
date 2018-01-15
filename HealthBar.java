import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class creates a rectangle representing the percentage of health left in a 
 * character. It updates according to the stored health variable in its instances.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class HealthBar extends Actor
{
    double health; // total health available in health bar
    double healthBarWidth = 137;
    int healthBarHeight = 12;
    double pixelsPerHealthPoint; // amount of pixels in the health bar per hp

    // constructor initialises the full health that's passed to it and determines how many pixels it occupies
    public HealthBar(int health){
        this.health = health;
        pixelsPerHealthPoint = healthBarWidth / health;
    }

    public void act() 
    {
        update();
    }

    // this method redraws the image of the health bar as health decreases
    public void update(){
        setImage(new GreenfootImage((int)healthBarWidth, healthBarHeight));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1, (int)(health * pixelsPerHealthPoint), healthBarHeight);
    }

    // this method sets the health of the health bar 
    public void setHealth(int health){
        this.health = health;
    }

    // this method gets the health of the health bar 
    public int getHealth(){
        return (int)health;
    }
}
