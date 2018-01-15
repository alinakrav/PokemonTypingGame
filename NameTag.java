import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class creates a name tag unique to a character. It
 * uses a ready image of the base tag with their name included,
 * and places their unique HP on the tag, represented numerically
 * and visually through a health bar that is framed by a provided
 * health bar frame image (for a nicer look).
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class NameTag extends Actor
{
    boolean started; // whether first act was played yet
    String name; // character name
    int health; // character health
    GreenfootImage image;
    int hpBarX, hpBarY, hpCounterX, hpCounterY, hpBarFrameX, hpBarFrameY, x, y; // location of all name tag components
    HealthBar healthBar; // healthBar object related to this tag
    HealthCounter healthCounter; // healthCounter object related to this tag

    // constructor takes arguments that it needs to build a name tag for given character
    public NameTag(String name, int health, int x, int y) {
        this.name = name; // declare name
        image = new GreenfootImage(name + "Tag.png"); // image is always "name of character" + "Tag.png"

        // create new health bar and counter using the character's health
        healthBar = new HealthBar(health); 
        healthCounter = new HealthCounter(health);
        // set x and y coordinates of tag
        this.x = x; 
        this.y = y;
        if(name.equals("player")) { 
            // health bar location relative to player's tag's location
            hpBarX = x + 51; 
            hpCounterX = x - 61;
        }
        else { 
            // enemies' health bars relative to their tag's locations
            hpBarX = x + 30;
            hpCounterX = x - 83;
        }

        // set health bar components' locations in relation to tag location
        hpBarY = y + 8; 
        hpBarFrameX = hpBarX + 1; 
        hpBarFrameY = hpBarY; 
        hpCounterY = y + 7; 

        //set and scale specific image for character
        setImage(image);
        image.scale(image.getWidth()/2,image.getHeight()/2);
    }

    public void act() 
    {
        if(!started) {
            // add health bar and counter on top of tag
            getWorld().addObject(healthBar, hpBarX, hpBarY);
            getWorld().addObject(healthCounter, hpCounterX, hpCounterY);
            // add health bar frame on top of health bar
            getWorld().addObject(new HealthFrame(), hpBarFrameX, hpBarFrameY);
            started = true; // only do this in the first act
        }
    }    

    // this method sets the health displayed on this name tag
    public void setHealth(int health) {
        healthBar.setHealth(health);
        healthCounter.setHealth(health);
    }

    // this method returns the x coordinate of the name tag
    public int getX() {
        return x;
    }

    // this method returns the y coordinate of the name tag
    public int getY() {
        return y;
    }
}
