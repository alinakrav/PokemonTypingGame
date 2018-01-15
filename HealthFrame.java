import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to display a frame that can be placed over a health bar.
 * It makes the health bar more integrated into the look of the game.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class HealthFrame extends Actor
{
    //constructor sets and resizes the image for this object
    public HealthFrame() {
        this.setImage(new GreenfootImage("hpFrame.png"));
        this.getImage().scale(144,18);
    }
}
