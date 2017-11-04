import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class XP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    int health;
    int healthBarWidth = 160;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint;
    
    //https://youtu.be/oJHP18bhLT0
    public HealthBar(int health){
        this.health = health;
        pixelsPerHealthPoint = (int)healthBarWidth / health;
    }
    /**
     * Act - do whatever the XP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        update();
        
        /*if(health <= 0){
            World world = getWorld();
            world.removeObjects(world.getObjects(null)); //removes all the objects in the world;
        }**/
        
    }
    public void update(){
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth+1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight);
    }
    public void lowerHealth(){
        health--;
    }
    public void lowerHealth(int health){ //lose health by a set int value
        this.health-=health;
    }
    public void setHealthAndHealthBarWidth(int health, int width){ //set new health
        this.health = health;
        healthBarWidth = width;
    }
    public int getHealth(){
        return health;
    }
}
